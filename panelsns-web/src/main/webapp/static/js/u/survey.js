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
		formName:"searchForm",
		init:function(){
			$.core.initPager("searchForm");
			$("div.order_col").click($.survey.search.processOrder);
			$("select[name='surveyStatus']").change($.survey.search.processStatus);
			$("dl.my_survey dd").click($.survey.search.processSelectSurvey);
		},
		processOrder:function(event){
			var submitForm=$("#"+$.survey.search.formName);
			if(submitForm.length<1){
				alert("there is no submit form ! your form is "+$.survey.search.formName);
				return ;
			}
			$("#orderCol",submitForm).val($(this).attr("orderCol"));
			$("#orderType",submitForm).val($(this).attr("orderType"));
			submitForm.submit();
		},
		processStatus:function(event){
			var submitForm=$("#"+$.survey.search.formName);
			if(submitForm.length<1){
				alert("there is no submit form ! your form is "+$.survey.search.formName);
				return ;
			}
			var checkOpt=$("option:selected",this);
			$("#status",submitForm).val(checkOpt.val());
			submitForm.submit();
		},
		processSelectSurvey:function(event){
			$("dl.my_survey dd[id!='"+$(this).attr("id")+"']").removeClass("seling");
			$(this).addClass("seling");
			var rightBlock=$("div.right_block");
			var infoLink=$(".survey_info_link",rightBlock);
			infoLink.text($(this).attr("surveyName"));
			infoLink.attr("href",$(infoLink).attr("preHref")+$(this).attr("surveyName"));
		}
	};
})(jQuery);