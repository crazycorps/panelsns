(function($) {
	$(document).ready(function(){
		$.naire.init();
	});
	$.naire={
		init:function(){
			$.naire.initLayout();
			var moduleName="add";
			if($("#moduleName").length>0){
				moduleName=$("#moduleName").val();
			}
			$.naire[moduleName].init();
			
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
	$.naire.add={
		formName:"naireForm",
		init:function(){

		}
	};
})(jQuery);