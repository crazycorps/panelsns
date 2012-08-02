(function($) {
	$(document).ready(function(){
		$.survey.init();
	});
	$.survey={
		init:function(){
			var moduleName="search";
			if($("#moduleName").length>0){
				moduleName=$("#moduleName").val();
			}
			$.survey[moduleName].init();
		}
	};
	$.survey.search={
		init:function(){
			$.core.initPager("searchForm");
		}
	};
})(jQuery);