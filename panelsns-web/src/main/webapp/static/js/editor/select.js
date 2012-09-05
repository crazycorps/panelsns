(function($) {
	$(document).ready(function(){
		//$.editor.init();
	});
	
	$.editor.select={
		init:function(){
			$.editor.select.initEvents();
		},
		initDatas:function(formEle,quesTypeOption,quesMess){
			if(formEle==null||formEle==undefined){
				return ;
			}
			$.editor.select.initQuesTypeOptionData(formEle,quesTypeOption);
			$.editor.select.initQuesMess(formEle,quesTypeOption,quesMess);
		},
		initQuesTypeOptionData:function(formEle,quesTypeOption){
			if(quesTypeOption==null||quesTypeOption==undefined){
				return ;
			}
			var isRequire=quesTypeOption.isRequire;
			if(isRequire){
				$("#is_require",formEle).prop("checked","checked");
			}
			var isHasIntro=quesTypeOption.isHasIntro;
			if(isHasIntro){
				$("#intro_trigger",formEle).prop("checked","checked");
			}
			var quesType=quesTypeOption.quesType;
			if(quesType!=null&&quesType!=undefined){
				$("select[name='form_type'] option[value='"+quesType+"']",formEle).prop("selected",'selected');
				
				var leastChoice=quesTypeOption.leastChoice;
				if(leastChoice!=null&&leastChoice!=undefined&&leastChoice!=""&&!isNaN(leastChoice)&&quesType=="checkbox"){
					$("#set_choice_limit input[name='least_choice']",formEle).val(leastChoice);
				}
				var mostChoice=quesTypeOption.mostChoice;
				if(mostChoice!=null&&mostChoice!=undefined&&mostChoice!=""&&!isNaN(mostChoice)&&quesType=="checkbox"){
					$("#set_choice_limit input[name='most_choice']",formEle).val(mostChoice);
				}
			}
			
			var directionType=quesTypeOption.directionType;
			if(quesType!=null&&quesType!=undefined){
				$("select[name='direction'] option[value='"+directionType+"']",formEle).prop("selected",'selected');
				
				var columnNumber=quesTypeOption.columnNumber;
				if(columnNumber!=null&&columnNumber!=undefined&&columnNumber!=""&&!isNaN(columnNumber)&&directionType=="custom"){
					$("#set_column_number input[name='column_per_row']",formEle).val(columnNumber);
				}
			}
			
			var isShuffle=quesTypeOption.isShuffle;
			if(isShuffle){
				$("#shuffle_options",formEle).prop("checked","checked");
			}
			
		},
		initQuesMess:function(formEle,quesTypeOption,quesMess){
			if(quesMess==null||quesMess==undefined){
				return ;
			}
			var title=quesMess.title;
			if($.util.isNotEmpty(title)){
				$("input[name='subject']",formEle).val(title);
			}
			var intro=quesMess.intro;
			var isIntro=$("#intro_trigger",formEle).prop("checked");
			if(isIntro){
				$("textarea[name='intro']",formEle).val(intro);
			}
			
			var quesOptionMessList=quesMess.quesOptionMessList;
			if(quesOptionMessList==null||quesOptionMessList==undefined){
				return ;
			}
			var optLength=quesOptionMessList.length;
			var optionsEles=$("div.options div.list",formEle);
			var firstOptionEle=$("div.select_option:first",optionsEles);
			for(var i=1;i<optLength;i++){
				optionsEles.append(firstOptionEle.clone(true));
			}
			
			$.each($("div.select_option",optionsEles),function(i,n){
				var quesOptionMess=quesOptionMessList[i];
				var content=quesOptionMess.content;
				if($.util.isNotEmpty(content)){
					$(":text[name='label']",n).val(content);
				}
				var allowSpecify=quesOptionMess.allowSpecify;
				if(allowSpecify){
					$("#allowSpecify",n).prop("checked","checked");
				}
			});
			
		},
		initEvents:function(){
			$("select[name='form_type']").change($.editor.select.formTypeChangeEvent);
			$("select[name='direction']").change($.editor.select.directionChangeEvent);
		},
		formTypeChangeEvent:function(event){
			var typeVal=$(this).val();
			if("checkbox"==typeVal){
				$("#set_choice_limit").show();
				$("#set_options_layout").show();
			}else if("select"==typeVal){
				$("#set_choice_limit :text").val("");
				
				$("#set_choice_limit").hide();
				$("#set_options_layout").hide();
			}else{
				// 默认单选
				$("#set_choice_limit :text").val("");
				
				$("#set_choice_limit").hide();
				$("#set_options_layout").show();
			}
		},
		directionChangeEvent:function(event){
			var directionVal=$(this).val();
			if("custom"==directionVal){
				$("#set_column_number").show();
			}else{
				$("#set_column_number :text").val("");
				$("#set_column_number").hide();
			}
		}
	};
	
})(jQuery);