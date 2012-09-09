(function($) {
	$(document).ready(function(){
		$.naire.init();
	});
	$.naire={
		init:function(){
			$.naire.initLayout();
			$.naire.edit.init();
		},
		initLayout:function(){
			$( "#tabs_main" ).tabs();
		}
	};
	$.naire.edit={
		surveyId:0,
		naireId:0,
		treeId:"tree_page",
		nowPageNo:1,
		pageMess:{
			p_0:{
				q_0:{
					quesTypeOption:null,
					quesMess:null
				}
			}
		},
		init:function(){
			$.naire.edit.initDatas();
			$.naire.edit.initEvents();
		},
		initDatas:function(){
			$.naire.edit.initTreePanel();
			$.naire.edit.initNaireEditorTemplate();
		},
		initTreePanel:function(){
			var treeSetting={
				view:{
					showLine:false,
					dblClickExpand:function(treeId, treeNode){
						return treeNode.level > 0;
					}
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback:{
					onClick:$.naire.edit.treeNodeClick
				}
			}
			var zNodes =[
	 			{ id:1, pId:0, name:"问卷页数", open:true},
	 			{ id:2, pId:1, name:"第1页",pageNo:1},
	 		];
			$.fn.zTree.init($("#tree_page"), treeSetting, zNodes);
			var treeObj = $.fn.zTree.getZTreeObj($.naire.edit.treeId);
			var firstPageNode = treeObj.getNodeByTId($.naire.edit.treeId+"_2");
			treeObj.selectNode(firstPageNode,false);
			$.naire.edit.addNairePageCon(firstPageNode.pageNo);
			$.naire.edit.pageSelected($.naire.edit.treeId,firstPageNode.tId,firstPageNode.pageNo);
		},
		initNaireEditorTemplate:function(){
			// 加载单选题编辑模版
			$.ajax({
			   type: "GET",
			   url: "/templates/ques/select.html",
			   data: "type=singleSelect",
			   dataType:"html",
			   success: function(content){
				   $("#select_template_con").append(content);
				   var editorCallBack={
					   select:$.naire.edit.editorCallback.select
				   };
				   $.editor.select.init(editorCallBack);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   
			   }
			});
		},
		initDefaultPageMess:function(pid,qid,quesType){
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				pageMess={};
			}
			var quesAllMess=pageMess["q_"+qid];
			if(quesAllMess==null||quesAllMess==undefined){
				var quesTypeOption=null;
				var quesMess=null;
				if($.quesType.singleSelect==quesType){
					quesTypeOption=$.editor.defaultQuesTypeOption;
					quesMess =$.editor.defaultQuesMess;
				}else if($.quesType.multiSelect==quesType){
					quesTypeOption=$.editor.multiSelectQuesTypeOption;
					quesMess =$.editor.defaultQuesMess;
				}else{
					quesTypeOption=$.editor.defaultQuesTypeOption;
					quesMess =$.editor.defaultQuesMess;
				}
				var quesAllMess={
					quesTypeOption:quesTypeOption,
					quesMess:quesMess
				};
				$(pageMess).attr("q_"+qid,quesAllMess);
			}
			$.naire.edit.pageMess["p_"+pid]=pageMess;
			return pageMess;
		},
		removePageMess:function(pid){
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				return ;
			}
			delete $.naire.edit.pageMess["p_"+pid];
		},
		removePageQuesAllMess:function(pid,qid){
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				return ;
			}
			var quesAllMess=pageMess["q_"+qid];
			if(quesAllMess==null||quesAllMess==undefined){
				return ;
			}
			delete pageMess["q_"+qid];
		},
		replacePageQuesAllMess:function(pid,fromQid,toQid){
			// 更改题目的时候确保改变到的题号，没有相关信息
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				return ;
			}
			var fromQuesAllMess=pageMess["q_"+fromQid];
			if(fromQuesAllMess==null||fromQuesAllMess==undefined){
				return ;
			}
			var toQuesAllMess=pageMess["q_"+toQid];
			if(toQuesAllMess!=null&&toQuesAllMess!=undfined){
				var confirmCommand=window.confirm(toQid+"题号数据，将被替换？");
				if(!confirmCommand){
					return ;
				}
			}
			pageMess["q_"+toQid]=fromQuesAllMess;
			delete pageMess["q_"+fromQid];
		},
		changePageQuesAllMess:function(pid,fromQid,toQid){
			// 更改题目的时候确保改变到的题号，没有相关信息
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				return ;
			}
			var fromQuesAllMess=pageMess["q_"+fromQid];
			if(fromQuesAllMess==null||fromQuesAllMess==undefined){
				return ;
			}
			var toQuesAllMess=pageMess["q_"+toQid];
			if(toQuesAllMess==null||toQuesAllMess==undefined){
				return ;
			}
			pageMess["q_"+toQid]=fromQuesAllMess;
			pageMess["q_"+fromQid]=toQuesAllMess;
		},
		initEvents:function(){
			// 新建页事件
			$("#add_page").click($.naire.edit.addPage);
			$("#remove_page").click($.naire.edit.delPage);
			
			$("#part_toolbar .save").click($.naire.edit.naireSave);
			
			$.naire.edit.initEditorQuesEvents(); 
		},
		initEditorQuesEvents:function(){
			$("#add_select_radio").click($.naire.edit.addEditorSingleSelect);
			$("#add_select_checkbox").click($.naire.edit.addEditorMultiSelect);
		},
		addPage:function(event){
			var treeObj = $.fn.zTree.getZTreeObj($.naire.edit.treeId);
			var parentNode = treeObj.getNodeByTId($.naire.edit.treeId+"_1");
			var nodes = parentNode.children;
			var maxPageNo=1;
			$.each(nodes,function(i,node){
				if(maxPageNo<node.pageNo){
					maxPageNo=node.pageNo;
				}
			});
			var newPageNo=maxPageNo+1;
			var newNode = {name:"第"+newPageNo+"页",pageNo:newPageNo};
			newNode = treeObj.addNodes(parentNode, newNode);
			var treeNewNode = treeObj.getNodeByTId($.naire.edit.treeId+"_"+(newPageNo+1));
			treeObj.selectNode(treeNewNode,false);
			$.naire.edit.addNairePageCon(treeNewNode.pageNo);
			$.naire.edit.pageSelected($.naire.edit.treeId,treeNewNode.tId,treeNewNode.pageNo);
		},
		delPage:function(event){
			var treeObj = $.fn.zTree.getZTreeObj($.naire.edit.treeId);
			var parentNode = treeObj.getNodeByTId($.naire.edit.treeId+"_1");
			var pageNodes = parentNode.children;
			if(pageNodes.length==1){
				alert("至少保留一页");
				return ;
			}
			var nodes = treeObj.getSelectedNodes();
			$.each(nodes,function(i,node){
				$("#edit_naire_view div.naire_page[pageNo='"+node.pageNo+"']").remove();
				$.naire.edit.removePageMess(node.pageNo);
				treeObj.removeNode(node);
			});
			var maxPageNo=1;
			$.each(pageNodes,function(i,node){
				var newPageNo=i+1;
				$("#edit_naire_view div.naire_page[pageNo='"+node.pageNo+"']").attr("pageNo",newPageNo);
				node.pageNo=newPageNo;
				node.name="第"+node.pageNo+"页";
				treeObj.updateNode(node);
			});
			var firstPageNode = treeObj.getNodeByTId($.naire.edit.treeId+"_2");
			treeObj.selectNode(firstPageNode,false);
			$.naire.edit.pageSelected($.naire.edit.treeId,firstPageNode.tId,firstPageNode.pageNo);
		},
		pageSelected:function(treeId,treeNodeId,pageNo){
			$.naire.edit.nowPageNo=pageNo;
			$("#edit_naire_view div.naire_page[pageNo='"+$.naire.edit.nowPageNo+"']").show();
			$("#edit_naire_view div.naire_page[pageNo!='"+pageNo+"']").hide();
		},
		treeNodeClick:function(event,treeId,treeNode,clickFlag){
			$.naire.edit.pageSelected(treeId,treeNode.tId,treeNode.pageNo);
		},
		addNairePageCon:function(pageNo){
			var pageDiv=$("#naire_page_template div.naire_page").clone(true);
			$(pageDiv).attr({
				"pageNo":pageNo
			});
			$("#edit_naire_view").append(pageDiv);
		},
		addEditorSingleSelect:function(event){
			$.naire.edit.addEditorQues($.quesType.singleSelect);
		},
		addEditorMultiSelect:function(event){
			$.naire.edit.addEditorQues($.quesType.multiSelect);
		},
		removeEditor:function(event){
			var editorLiEle=$(this).parents("li.part[qid][t]");
			var currnetNairePage=$(this).parents("div.naire_page");
			var pid=currnetNairePage.attr("pageno");
			var qid=$(editorLiEle).attr("qid");
			$.naire.edit.removePageQuesAllMess(pid,qid);
			editorLiEle.remove();
			
			var nowEditorLiEles=$("li.part[qid][t]",currnetNairePage);
			$.each(nowEditorLiEles,function(i,n){
				var tempQid=parseInt($(this).attr("qid"));
				var toQid=i+1;
				// 如果在删除题目的下方，则需要移动
				if(tempQid==toQid){
					return ;
				}
				$(this).attr("qid",toQid);
				$("[qid]",this).attr("qid",toQid);
				$.naire.edit.replacePageQuesAllMess(pid,tempQid,toQid);
			});
		},
		moveupEditor:function(event){
			var editorLiEle=$(this).parents("li.part[qid][t]");
			var currnetNairePage=$(this).parents("div.naire_page");
			var pid=currnetNairePage.attr("pageno");
			var qid=$(editorLiEle).attr("qid");
			// 如果是第一题，则不能向上移动
			if(qid==1){
				return ;
			}
			var preEditorLiEle=$(editorLiEle).prev("li.part[qid][t]");
			var prevQid=$(preEditorLiEle).attr("qid");
			
			$(editorLiEle).attr("qid",prevQid);
			$("[qid]",editorLiEle).attr("qid",prevQid);
			
			$(preEditorLiEle).attr("qid",qid);
			$("[qid]",preEditorLiEle).attr("qid",qid);
			
			$(preEditorLiEle).before(editorLiEle);
			
			$.naire.edit.changePageQuesAllMess(pid,qid,prevQid);
			
		},
		movedownEditor:function(event){
			var editorLiEle=$(this).parents("li.part[qid][t]");
			var currnetNairePage=$(this).parents("div.naire_page");
			var pid=currnetNairePage.attr("pageno");
			var qid=$(editorLiEle).attr("qid");
			
			var nextEditorLiEle=$(editorLiEle).next("li.part[qid][t]");
			if(nextEditorLiEle.length<1){
				return;
			}
			var nextQid=$(nextEditorLiEle).attr("qid");
			
			$(editorLiEle).attr("qid",nextQid);
			$("[qid]",editorLiEle).attr("qid",nextQid);
			
			$(nextEditorLiEle).attr("qid",qid);
			$("[qid]",nextEditorLiEle).attr("qid",qid);
			
			$(nextEditorLiEle).after(editorLiEle);
			
			$.naire.edit.changePageQuesAllMess(pid,qid,nextQid);
		},
		addEditorQues:function(quesType){
			// 单选
			var cloneSingleSelEle=$("#select_template_con ol.single_select_option_template").children().clone();
			var nowPageCon=$("#edit_naire_view div.naire_page[pageNo='"+$.naire.edit.nowPageNo+"']");
			var maxQuesNo=$("li.part",nowPageCon).size();
			var newQuesNo=maxQuesNo+1;
			$("ol.content",nowPageCon).append(cloneSingleSelEle);
			$(cloneSingleSelEle).attr({
				qId:newQuesNo,// 一页中题号
				t:$.quesType.singleSelect//
			}).hover(
				function () {
				    $("div.float_buttons",this).show();
				},
				function () {
					$("div.float_buttons",this).hide();
				}
			);
			$("div.float_buttons button[name='edit']",cloneSingleSelEle).click($.naire.edit.triggerEditorSelectForm);
			$("div.float_buttons button[name='remove']",cloneSingleSelEle).click($.naire.edit.removeEditor);
			$("div.float_buttons button[name='moveup']",cloneSingleSelEle).click($.naire.edit.moveupEditor);
			$("div.float_buttons button[name='movedown']",cloneSingleSelEle).click($.naire.edit.movedownEditor);
			// 渲染默认数据
			var pid=$.naire.edit.nowPageNo;
			var qid=newQuesNo;
			var pageMess=$.naire.edit.initDefaultPageMess(pid,qid,quesType);
			var quesAllMess=pageMess["q_"+qid];
			var generatedQuesEle=$.render.render(pid,qid,quesAllMess.quesTypeOption,quesAllMess.quesMess);
			var partRenderConEle=$("div.ques_render_con",cloneSingleSelEle);
			// 把之前的删除掉
			partRenderConEle.empty();
			
			$(partRenderConEle).append(generatedQuesEle);
		},
		triggerEditorSelectForm:function(event){
			var currnetNairePage=$(this).parents("div.naire_page");
			var pid=currnetNairePage.attr("pageno");
			var qid=$(this).parents("li.part[qid][t]").attr("qid");
			$("form.part_editor",currnetNairePage).remove();
			var editorFormEle=$("#select_template_con form.part_editor").clone(true);
			editorFormEle.attr({
				pid:pid,
				qid:qid
			});
			var editorLiEle=$(this).parents("li.part[qid][t]");
			$(editorLiEle).after(editorFormEle);
			$(editorLiEle).hide();
			$("li.part[qid!='"+$(editorLiEle).attr("qid")+"']",currnetNairePage).show();
			
			// 初始化编辑form数据
			var pageMess=$.naire.edit.initDefaultPageMess(pid,qid);
			var quesAllMess=pageMess["q_"+qid];
			
			$.editor.select.initDatas(editorFormEle,quesAllMess.quesTypeOption,quesAllMess.quesMess);
		},
		editorCallback:{
			select:function(pid,qid,quesTypeOption,quesMess){
				var pageMess=$.naire.edit.pageMess["p_"+pid];
				if(pageMess==null||pageMess==undefined){
					pageMess=$.naire.edit.initDefaultPageMess(pid,qid);
				}
				var quesAllMess=pageMess["q_"+qid];
				$(quesAllMess).attr({
					quesTypeOption:quesTypeOption,
					quesMess:quesMess
				});
				$.naire.edit.render(pid,qid,quesTypeOption,quesMess);
			}
		},
		render:function(pid,qid,quesTypeOption,quesMess){
			
			var currnetNairePage=$("div.naire_page[pageno='"+pid+"']");
			if(currnetNairePage.length<1){
				return ;
			}
			var currentEditorForm=$("form.part_editor[qid='"+qid+"']",currnetNairePage);
			if(currentEditorForm.length<1){
				return ;
			}
			
			var generatedQuesEle=$.render.render(pid,qid,quesTypeOption,quesMess);
			if(generatedQuesEle==null||generatedQuesEle==undefined){
				return ;
			}
			
			var partEle=$("li.part[qid='"+qid+"']",currnetNairePage);
			var partRenderConEle=$("div.ques_render_con",partEle);
			// 把之前的删除掉
			partRenderConEle.empty();
			
			currentEditorForm.remove();
			$(partRenderConEle).append(generatedQuesEle);
			partEle.show();
		},
		naireSave:function(event){
			// 加载单选题编辑模版
			$.naire.edit.checkAndRepairPageMess();
			var datas={
				surveyId:$.naire.edit.surveyId,
				naireId:$.naire.edit.naireId,
				pageMess: $.toJSON({pageMess:$.naire.edit.pageMess})
			};
			$.ajax({
			   type: "POST",
			   url: "/u/naire/update/",
			   data: $.param(datas),
			   dataType:"JSON",
			   success: function(content){
				   var con=content;
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   
			   }
			});
		},
		checkAndRepairPageMess:function(){
			$.each($.naire.edit.pageMess,function(pid,quesList){
				$.each(quesList,function(qid,quesAllMess){
					var quesTypeOption=quesAllMess.quesTypeOption;
					var quesMess=quesAllMess.quesMess;
					if(quesTypeOption==null||quesMess==null){
						return true;
					}
					if(quesTypeOption.leastChoice==""){
						quesTypeOption.leastChoice=0;
					}
					if(quesTypeOption.mostChoice==""){
						quesTypeOption.mostChoice=0;
					}
					if(quesTypeOption.columnNumber==""){
						quesTypeOption.columnNumber=0;
					}
					
					if(quesMess.quesOptionMessList==null){
						return true;
					}
					$.each(quesMess.quesOptionMessList,function(i,quesOpt){
						if(quesOpt.inputWidth==""){
							quesOpt.inputWidth=0;
						}
						if(quesOpt.leastInput==""){
							quesOpt.leastInput=0;
						}
						if(quesOpt.mostInput==""){
							quesOpt.mostInput=0;
						}
					});
					
				});
			});
		}
		
	};
})(jQuery);