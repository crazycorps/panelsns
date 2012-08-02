(function($) {
	$.core={
		initPager:function(formName){
			var eventData={
				formName:formName
			};
			$(".pager_tag .pager a[topage]").bind("click",eventData,$.core.processPager);
			$(".pager_tag .pager_jump input[type='button']").bind("click",eventData,$.core.processPagerJump);
		},
		pagerSumit:function(event){
			var submitForm=$("#"+event.data.formName);
			if(submitForm.length<1){
				alert("there is no submit form ! your form is "+event.data.formName);
				return ;
			}
			var toPageEle=$("#toPage",submitForm);
			if(toPageEle.length<1){
				alert("there is no toPage params  in your "+event.data.formName+"!");
				return ;
			}
			$(toPageEle).val(event.data.toPageNum);
			submitForm.submit();
		},
		processPager:function(event){
			var toPageNum=$(this).attr("topage");
			event.data.toPageNum=toPageNum;
			$.core.pagerSumit(event);
		},
		processPagerJump:function(event){
			var jumpPageNumEle=$(this).prev("input[type='text'][name='pagerJumpNo']");
			if(jumpPageNumEle.length<1){
				alert("there is no pagerJumpNo params !");
				return ;
			}
			var toPageNum=1;
			if(jumpPageNumEle.val()!=""&&!isNaN(jumpPageNumEle.val())){
				toPageNum=jumpPageNumEle.val();
			}
			event.data.toPageNum=toPageNum;
			$.core.pagerSumit(event);
		}
	};
})(jQuery);