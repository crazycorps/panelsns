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
			$();
		}
	};
	$.naire.add={
		formName:"naireForm",
		init:function(){

		}
	};
})(jQuery);