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
		currentPage:1,
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
			var treeObj = $.fn.zTree.getZTreeObj("tree_page");
			var firstPageNode = treeObj.getNodeByTId("tree_page_2");
			treeObj.selectNode(firstPageNode,false);
		},
		initNaireEditorTemplate:function(){
			// 加载单选题编辑模版
			$.ajax({
			   type: "GET",
			   url: "/templates/ques/select.html",
			   data: "type=singleSelect",
			   dataType:"html",
			   success: function(content){
				   $("#single_select_con").append(content);
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
			var treeObj = $.fn.zTree.getZTreeObj("tree_page");
			var parentNode = treeObj.getNodeByTId("tree_page_1");
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
			var treeNewNode = treeObj.getNodeByTId("tree_page_"+(newPageNo+1));
			treeObj.selectNode(treeNewNode,false);
			var pageDiv=document.createElement("div");
			$(pageDiv).attr({
				"pageNo":newPageNo,
				"class":"naire_page"
			});
			$("#edit_naire_view").append(pageDiv);
			$("#edit_naire_view div[pageNo!='"+newPageNo+"']").hide();
		},
		delPage:function(event){
			var treeObj = $.fn.zTree.getZTreeObj("tree_page");
			var nodes = treeObj.getSelectedNodes();
			$.each(nodes,function(i,node){
				$("#edit_naire_view div[pageNo='"+node.pageNo+"']").remove();
				treeObj.removeNode(node);
			});
			var parentNode = treeObj.getNodeByTId("tree_page_1");
			var pageNodes = parentNode.children;
			var maxPageNo=1;
			$.each(pageNodes,function(i,node){
				var newPageNo=i+1;
				$("#edit_naire_view div[pageNo='"+node.pageNo+"']").attr("pageNo",newPageNo);
				node.pageNo=newPageNo;
				node.name="第"+node.pageNo+"页";
				treeObj.updateNode(node);
			});
		},
		treeNodeClick:function(event,treeId,treeNode,clickFlag){
			var t=treeId;
		},
		addEditorSingleSelect:function(event){
			// 单选
			
		}
	};
})(jQuery);