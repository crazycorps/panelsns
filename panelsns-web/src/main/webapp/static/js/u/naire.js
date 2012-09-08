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
		initDefaultPageMess:function(pid,qid){
			var pageMess=$.naire.edit.pageMess["p_"+pid];
			if(pageMess==null||pageMess==undefined){
				pageMess={};
			}
			var quesAllMess=pageMess["q_"+qid];
			if(quesAllMess==null||quesAllMess==undefined){
				var quesTypeOption=$.editor.defaultQuesTypeOption;
				var quesMess =$.editor.defaultQuesMess;
				var quesAllMess={
					quesTypeOption:quesTypeOption,
					quesMess:quesMess
				};
				$(pageMess).attr("q_"+qid,quesAllMess);
			}
			$.naire.edit.pageMess["p_"+pid]=pageMess;
			return pageMess;
		},
		initEvents:function(){
			// 新建页事件
			$("#add_page").click($.naire.edit.addPage);
			$("#remove_page").click($.naire.edit.delPage);
			
			$.naire.edit.initEditorQuesEvents(); 
		},
		initEditorQuesEvents:function(){
			$("#add_select_radio").click($.naire.edit.addEditorSingleSelect);
			
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
			).click($.naire.edit.triggerEditorSelect);
			
			// 初始化数据
			var subjectEle=$(".title .subject",cloneSingleSelEle);
			var pqId="p_"+$.naire.edit.nowPageNo+"_q_"+newQuesNo;
			subjectEle.text(pqId+":"+subjectEle.text());
			
			// 默认竖向展示
			var optionLayoutEle=$("div.content",cloneSingleSelEle);
			var optionRadioVertical=$("#option_template div.option_radio_vertical");
			$(optionLayoutEle).append(optionRadioVertical.clone(true));
		},
		triggerEditorSelect:function(event){
			var currnetNairePage=$(this).parents("div.naire_page");
			var pid=currnetNairePage.attr("pageno");
			var qid=$(this).attr("qid");
			$("form.part_editor",currnetNairePage).remove();
			var editorFormEle=$("#select_template_con form.part_editor").clone(true);
			editorFormEle.attr({
				pid:pid,
				qid:qid
			});
			$(this).after(editorFormEle);
			$(this).hide();
			$("li.part[qid!='"+$(this).attr("qid")+"']",currnetNairePage).show();
			
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
				$.naire.edit.render.render(pid,qid,quesTypeOption,quesMess);
			}
		},
		render:{
			render:function(pid,qid,quesTypeOption,quesMess){
				var quesType=quesTypeOption.quesType;
				var directionType=quesTypeOption.directionType;
				if($.quesType.singleSelect==quesType){
					if($.optionLayout.vertical==directionType){
						$.naire.edit.render.renderVerticalRadio(pid,qid,quesTypeOption,quesMess);
					}
				}
			},
			renderVerticalRadio:function(pid,qid,quesTypeOption,quesMess){
				var currnetNairePage=$("div.naire_page[pageno='"+pid+"']");
				if(currnetNairePage.length<1){
					return ;
				}
				var currentEditorForm=$("form.part_editor[qid='"+qid+"']",currnetNairePage);
				if(currentEditorForm.length<1){
					return ;
				}
				var partEle=$("li.part[qid='"+qid+"']",currnetNairePage);
				var partConEle=$("div.content",partEle);
				// 把之前的删除掉
				partConEle.empty();
				var radioName="p_"+pid+"_q_"+qid;
				
				$(".title .subject",partEle).text(radioName+":["+quesMess.title+"]");
				var optionRadioVertical=$("#option_template div.option_radio_vertical").clone(true);
				var nowHaveOptionTrEles=$("table.options tr",optionRadioVertical);
				var quesOptionMessList=quesMess.quesOptionMessList;
				var optionLen=quesOptionMessList.length;
				for(var i=nowHaveOptionTrEles.length;i<optionLen;i++){
					var cloneTrEle=nowHaveOptionTrEles.first().clone(true);
					$("table.options tbody",optionRadioVertical).append(cloneTrEle);
				}
				nowHaveOptionTrEles=$("table.options tr",optionRadioVertical);
				$.each(nowHaveOptionTrEles,function(i,n){
					if(i>optionLen){
						return false;
					}
					var quesOptMess=quesOptionMessList[i];
					if(quesOptMess==null||quesOptMess==undefined){
						return false;
					}
					var trClass="odd";
					if(i%2!=0){
						trClass="even"
					}
					$(n).removeClass().addClass(trClass);
					
					var inputRadioEle=$(":radio",n);
					var labelForEle=$("label",n);
					var radioId="p_"+pid+"_q_"+qid+"_"+i;
					$(inputRadioEle).attr({
						id:radioId,
						name:radioName,
						value:i
					});
					$(labelForEle).attr({
						"for":radioId
					}).text(quesOptMess.content);
				});
				currentEditorForm.remove();
				$(partConEle).append(optionRadioVertical);
				partEle.show();
			}
		}
	};
})(jQuery);