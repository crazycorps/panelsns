(function($) {
	$(document).ready(function(){
		$.naire.init();
	});
	$.naire={
		quesType:{
			singleSelect:1,
			multiSelect:2,
			fillBlank:3,
			matrixSelect:4
		},
		init:function(){
			$.naire.initLayout();
			$.naire.edit.init();
		},
		initLayout:function(){
			$("#naire_tabs li[name]").click(function(){
				var name=$(this).attr("name");
				$(this).addClass("on");
				$("#naire_tabs li[name!='"+name+"']").removeClass("on");
				var currManager=name+"_manager";
				$("#main div[id$='_manager']").each(function(i,n){
					var mId=$(this).attr("id");
					if(mId==currManager){
						$(this).show();
					}else{
						$(this).hide();
					}
				});
			});
			$( "#tabs_main" ).tabs();
		}
	};
	$.naire.edit={
		treeId:"tree_page",
		nowPageNo:1,
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
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   
			   }
			});
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
				t:$.naire.quesType.singleSelect//
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
		},
		triggerEditorSelect:function(event){
			var currnetNairePage=$(this).parents("div.naire_page");
			$("form.part_editor",currnetNairePage).remove();
			var editorFormEle=$("#select_template_con form.part_editor").clone(true);
			$(this).after(editorFormEle);
			$(this).hide();
			$("li.part[qid!='"+$(this).attr("qid")+"']",currnetNairePage).show();
		}
	};
})(jQuery);