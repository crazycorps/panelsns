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
		}
	};
	$.naire.edit={
		currentPage:1,
		init:function(){
			$.naire.edit.initDatas();
			$.naire.edit.initEvents();
		},
		initDatas:function(){
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
		},
		initEvents:function(){
			// 新建页事件
			$("#add_page").click($.naire.edit.addPage);
			$("#remove_page").click($.naire.edit.delPage);
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
		},
		delPage:function(event){
			var treeObj = $.fn.zTree.getZTreeObj("tree_page");
			var nodes = treeObj.getSelectedNodes();
			$.each(nodes,function(i,node){
				treeObj.removeNode(node);
			});
			var parentNode = treeObj.getNodeByTId("tree_page_1");
			var pageNodes = parentNode.children;
			var maxPageNo=1;
			$.each(pageNodes,function(i,node){
				node.pageNo=i+1;
				node.name="第"+node.pageNo+"页";
				treeObj.updateNode(node);
			});
		},
		treeNodeClick:function(event,treeId,treeNode,clickFlag){
			var t=treeId;
		}
	};
})(jQuery);