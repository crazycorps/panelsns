(function($) {
	$(document).ready(function(){
		//$.editor.init();
	});
	
	$.editor.select={
		currentEditorForm:null,
		deleteQuesOpt:new Array(),
		init:function(editorCallBack){
			$.editor.select.initDialogs();
			$.editor.select.initEvents(editorCallBack);
		},
		initDatas:function(formEle,quesTypeOption,quesMess){
			if(formEle==null||formEle==undefined){
				return ;
			}
			$.editor.select.deleteQuesOpt=new Array();
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
				
				if(quesType==$.quesType.multiSelect){
					$("#set_choice_limit",formEle).show();
					var leastChoice=quesTypeOption.leastChoice;
					if(leastChoice!=null&&leastChoice!=undefined&&leastChoice!=""&&!isNaN(leastChoice)&&leastChoice!=0){
						$("#set_choice_limit input[name='least_choice']",formEle).val(leastChoice);
						
					}
					var mostChoice=quesTypeOption.mostChoice;
					if(mostChoice!=null&&mostChoice!=undefined&&mostChoice!=""&&!isNaN(mostChoice)&&mostChoice!=0){
						$("#set_choice_limit input[name='most_choice']",formEle).val(mostChoice);
					}
				}
				
			}
			
			var directionType=quesTypeOption.directionType;
			if(directionType!=null&&directionType!=undefined){
				$("select[name='direction'] option[value='"+directionType+"']",formEle).prop("selected",'selected');
				
				var columnNumber=quesTypeOption.columnNumber;
				if(columnNumber!=null&&columnNumber!=undefined&&columnNumber!=""&&!isNaN(columnNumber)&&columnNumber!=0&&directionType==$.optionLayout.custom){
					$("#set_column_number input[name='column_per_row']",formEle).val(columnNumber);
					$("#set_column_number",formEle).show();
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
			var subjectEle=$("input[name='subject']",formEle);
			subjectEle.attr("sn",quesMess.sn);
			var title=quesMess.title;
			if($.util.isNotEmpty(title)){
				subjectEle.val(title);
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
			
			var quesType=quesTypeOption.quesType;
			
			$.each($("div.select_option",optionsEles),function(i,n){
				var quesOptionMess=quesOptionMessList[i];
				var content=quesOptionMess.content;
				var quesOptEle=$(":text[name='label']",n);
				quesOptEle.attr("sn",quesOptionMess.sn);
				if($.util.isNotEmpty(content)){
					quesOptEle.val(content);
				}
				var quesOptionControlMess=quesOptionMess.quesOptionControlMess;
				var allowSpecify=quesOptionControlMess.allowSpecify;
				if(allowSpecify){
					$("#allowSpecify",n).prop("checked","checked");
					var inputWidth=quesOptionControlMess.inputWidth;
					if(inputWidth!=null&&inputWidth!=undefined&&inputWidth!=0){
						$("input[name='input_width']",n).val(inputWidth);	
					}
					var leastInput=quesOptionControlMess.leastInput;
					if(leastInput!=null&&leastInput!=undefined&&leastInput!=0){
						$("input[name='least_input']",n).val(leastInput);	
					}
					var mostInput=quesOptionControlMess.mostInput;
					if(mostInput!=null&&mostInput!=undefined&&mostInput!=0){
						$("input[name='most_input']",n).val(mostInput);	
					}
				}
				if(quesType==$.quesType.multiSelect){
					$(".setup_exclusive",n).show();
				}
				var isExclusive=quesOptionControlMess.isExclusive;
				if(isExclusive){
					$("input[name='exclusive']",n).prop("checked","checked");
				}
			});
			
		},
		addDeleteQuesOptMess:function(sn){
			if($.util.isEmpty(sn)||$.inArray($.editor.select.deleteQuesOpt,sn)!=-1){
				return ;
			}
			$.editor.select.deleteQuesOpt.push(sn);
		},
		initEvents:function(editorCallBack){
			$("select[name='form_type']").change($.editor.select.formTypeChangeEvent);
			$("select[name='direction']").change($.editor.select.directionChangeEvent);
			$("button[name='add_options']").click($.editor.select.addOptionsEvent);
			$("button.insert").click($.editor.select.insertOptionEvent);
			$("button.remove").click($.editor.select.removeOptionEvent);
			$(":checkbox[name='allow_specify']").click($.editor.select.allowSpecifyEvent);
			
			$("div.control button[name='close']").bind("click",{callBack:editorCallBack.select},$.editor.select.editorConfirmEvent);
		},
		formTypeChangeEvent:function(event){
			var typeVal=$(this).val();
			if($.quesType.multiSelect==typeVal){
				$("#set_choice_limit").show();
				$("#set_options_layout").show();
				$("div.options .setup_exclusive").show();
			}else if($.quesType.select==typeVal){
				$("#set_choice_limit :text").val("");
				
				$("#set_choice_limit").hide();
				$("#set_options_layout").hide();
				$("div.options .setup_exclusive").hide();
			}else{
				// 默认单选
				$("#set_choice_limit :text").val("");
				
				$("#set_choice_limit").hide();
				$("div.options .setup_exclusive").hide();
				$("#set_options_layout").show();
			}
		},
		directionChangeEvent:function(event){
			var directionVal=$(this).val();
			if($.optionLayout.custom==directionVal){
				$("#set_column_number").show();
			}else{
				$("#set_column_number :text").val("");
				$("#set_column_number").hide();
			}
		},
		addOptionsEvent:function(event){
			// 批量添加选项
			$.editor.select.currentEditorForm=$(this).parents("form.part_editor");
			$("#batchAddOptionsDialog").dialog("open");
		},
		insertOptionEvent:function(event){
			// 一个一个添加选项
			var currentEditorForm=$(this).parents("form.part_editor");
			var currentSelectOptEle=$(this).parents("div.select_option");
			var optionsEles=$("div.options div.list",currentEditorForm);
			var cloneSelectOptEle=currentSelectOptEle.clone(true);
			$(":text[name='label']",cloneSelectOptEle).val("");
			currentSelectOptEle.after(cloneSelectOptEle);
		},
		removeOptionEvent:function(event){
			// 删除选项
			var currentEditorForm=$(this).parents("form.part_editor");
			var optionsEles=$("div.options div.list div.select_option",currentEditorForm);
			if(optionsEles.length<=2){
				return ;
			}
			
			var currentSelectOptEle=$(this).parents("div.select_option");
			var quesOptEle=$(":text[name='label']",currentSelectOptEle);
			var sn=quesOptEle.attr("sn");
			$.editor.select.addDeleteQuesOptMess(sn);
			currentSelectOptEle.remove();
		},
		allowSpecifyEvent:function(event){
			// 是否可以为空
			var checked=$(this).prop("checked");
			var currentSelectOptEle=$(this).parents("div.select_option");
			if(checked){
				$(".setup_specify",currentSelectOptEle).show();
			}else{
				$(".setup_specify",currentSelectOptEle).hide();
			}
		},
		editorConfirmEvent:function(event){
			var currentEditorForm=$(this).parents("form.part_editor");
			var pid=currentEditorForm.attr("pid");
			var qid=currentEditorForm.attr("qid");
			
			var isRequire=$("#is_require",currentEditorForm).prop("checked");
			var isHasIntro=$("#intro_trigger",currentEditorForm).prop("checked");
			var quesType=$("select[name='form_type']",currentEditorForm).val();
			var leastChoice=$("#set_choice_limit input[name='least_choice']",currentEditorForm).val();
			var mostChoice=$("#set_choice_limit input[name='most_choice']",currentEditorForm).val();
			var directionType=$("select[name='direction']",currentEditorForm).val();
			var columnNumber=$("#set_column_number input[name='column_per_row']",currentEditorForm).val();;
			var isShuffle=$("#shuffle_options",currentEditorForm).prop("checked");
			var quesTypeOption= new QuesTypeOption(isRequire,isHasIntro,quesType,$.util.isNotEmpty(leastChoice)?leastChoice:0,$.util.isNotEmpty(mostChoice)?mostChoice:0,directionType,$.util.isNotEmpty(columnNumber)?columnNumber:0,isShuffle);
			
			var title=$("input[name='subject']",currentEditorForm).val();
			var intro=null;
			if(isHasIntro){
				intro=$("textarea[name='intro']",currentEditorForm).val();
			}
			var quesOptionMessList=new Array();
			$.each($("div.options div.list div.select_option",currentEditorForm),function(i,n){
				var content=$(":text[name='label']",n).val();
				var allowSpecify=$("#allowSpecify",n).prop("checked");
				var inputWidth=$("input[name='input_width']",n).val();
				var leastInput=$("input[name='least_input']",n).val();
				var mostInput=$("input[name='most_input']",n).val();
				var isExclusive=$("input[name='exclusive']",n).prop("checked");
				
				var quesOptionMess=new QuesOptionMess(null,content,allowSpecify,$.util.isNotEmpty(inputWidth)?inputWidth:0,$.util.isNotEmpty(leastInput)?inputWidth:0,$.util.isNotEmpty(mostInput)?inputWidth:0,isExclusive);
				quesOptionMessList.push(quesOptionMess);
			});
			var quesMess=new QuesMess(null,title,intro,quesOptionMessList);
			
			var callBack=event.data.callBack;
			if(callBack!=null&&callBack!=undefined&&$.isFunction(callBack)){
				callBack(pid,qid,quesTypeOption,quesMess,$.editor.select.deleteQuesOpt);
			}
		},
		initDialogs:function(event){
			$("#batchAddOptionsDialog").dialog({
				title:"批量添加",
				dialogClass:"option_dialog",
				draggable:true,
				bgiframe: true,
				autoOpen: false,
				resizable:false,
				minWidth:350,
				hide: { effect: 'drop', direction: "down" } ,
				position:"center",
				modal: true,
				buttons: [
			        {
			        	text: "保存",
			            click: function() {
			            	$.editor.select.batchAddOptionsDialogCallback($("textarea",this).val());
			            	$(this).dialog("close"); 
			            }
			        },
			        {
			        	text: "取消",
			            click: function() { 
			            	$(this).dialog("close"); 
			            }
			        }
				],
				close: function() {},
				open:function(){
					// 清空数据
					$("textarea",this).val("");
				}
			});
		},
		batchAddOptionsDialogCallback:function(content){
			if($.util.isEmpty(content)){
				return ;
			}
			var optList=content.split("\n");
			if(optList.length<1){
				return ;
			}
			if($.editor.select.currentEditorForm==null){
				return ;
			}
			
			var allOptCon=new Array();
			var optionsEles=$("div.options div.list",$.editor.select.currentEditorForm);
			var firstOptionEle=$("div.select_option:first",optionsEles);
			var nowHasOptionsEles=$("div.select_option",optionsEles);
			$.each(nowHasOptionsEles,function(i,n){
				var con=$(":text[name='label']",n).val();
				if($.util.isNotEmpty(con)){
					allOptCon.push(con);
				}
			});
			$.each(optList,function(i,n){
				var con=n;
				if($.util.isNotEmpty(con)){
					allOptCon.push(con);
				}
			});
			var needAppendOptEleLen=allOptCon.length-nowHasOptionsEles.length;
			for(var i=0;i<needAppendOptEleLen;i++){
				optionsEles.append(firstOptionEle.clone(true));
			}
			nowHasOptionsEles=$("div.select_option",optionsEles);
			$.each(nowHasOptionsEles,function(i,n){
				$(":text[name='label']",n).val(allOptCon[i]);
			});
			
		}
	};
	
})(jQuery);