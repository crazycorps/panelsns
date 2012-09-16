/**
 * 跟问卷相关的信息放到此
 */
(function($) {
	$.render={
		render:function(pid,qid,quesTypeOption,quesMess){
			// 返回对应的html元素
			var quesType=quesTypeOption.quesType;
			var directionType=quesTypeOption.directionType;
			if($.quesType.singleSelect==quesType){
				return $.render.renderSingleSelectQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}else if($.quesType.multiSelect==quesType){
				return $.render.renderMultiSelectQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}else if($.quesType.select==quesType){
				return $.render.renderDefaultSelectQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}else if($.quesType.fillBlank==quesType){
				return $.render.renderFillBlankQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}else if($.quesType.matrixSingleSelect==quesType){
				return $.render.renderMatrixSingleSelectQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}else if($.quesType.matrixMultiSelect==quesType){
				return $.render.renderMatrixMultiSelectQuesOpt.render(pid,qid,quesTypeOption,quesMess);
			}
			return null;
		}
	};
	// 单选（radio）
	$.render.renderSingleSelectQuesOpt={
		defaultClass:"single_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderSingleSelectQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderSingleSelectQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderSingleSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			quesTypeOption.columnNumber=1;
			return $.render.renderSingleSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			quesTypeOption.columnNumber=5;
			return $.render.renderSingleSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			var quesType=quesTypeOption.quesType;
			
			var quesConEle=document.createElement("div");
			$(quesConEle).attr({
				pid:pid,
				qid:qid
			}).addClass($.render.renderSingleSelectQuesOpt.defaultClass);
			
			// 问题title
			var quesTitleConEle=document.createElement("h4");
			$(quesTitleConEle).addClass("title dashed_line");
			var quesTitleSubjectEle=document.createElement("span");
			$(quesTitleSubjectEle).text(quesMess.title).addClass("subject");
			var quesTitleRequireEle=document.createElement("span");
			$(quesTitleRequireEle).text("*").css({
				"margin-left": "5px"
			}).addClass("require");
			$(quesTitleConEle).append(quesTitleSubjectEle).append(quesTitleRequireEle);
			$(quesConEle).append(quesTitleConEle);
			// 问题说明
			var quesIntroEle=document.createElement("div");
			$(quesIntroEle).addClass("intro");
			if($.util.isNotEmpty(quesMess.intro)){
				$(quesIntroEle).html(quesMess.intro).show();
			}else{
				$(quesIntroEle).hide();
			}
			$(quesConEle).append(quesIntroEle);
			
			// 问题选项
			var quesOptConEle=document.createElement("div");
			$(quesOptConEle).addClass("content");
			
			var quesOptTableEle=document.createElement("table");
			$(quesOptTableEle).addClass("options");
			var quesOptTableColGroupEle=document.createElement("colgroup");
			var quesOptionMessList=quesMess.quesOptionMessList;
			var quesOptionMessLen=quesOptionMessList.length;
			if($.util.isEmpty(quesTypeOption.columnNumber)){
				quesTypeOption.columnNumber=5;
			}
			var tempColNum=quesOptionMessLen/quesTypeOption.columnNumber;
			var colNum=quesTypeOption.columnNumber;
			if(tempColNum<1){
				colNum=quesOptionMessLen;
			}
			var colWidthRatio=100/colNum;
			for(var i=0;i<colNum;i++){
				var quesOptTableColGroupColEle=document.createElement("col");
				$(quesOptTableColGroupColEle).attr("width",colWidthRatio+"%");
				$(quesOptTableColGroupEle).append(quesOptTableColGroupColEle);
			}
			$(quesOptTableEle).append(quesOptTableColGroupEle);
			
			var quesOptName="p_"+pid+"_q_"+qid;
			var quesOptTableTrEle=null;
			$.each(quesOptionMessList,function(i,n){
				if(i%colNum==0){
					quesOptTableTrEle=document.createElement("tr");
					$(quesOptTableTrEle).attr({
						valign:"top"
					});
					if(i%2==0){
						$(quesOptTableTrEle).removeClass().addClass("odd");
					}else{
						$(quesOptTableTrEle).removeClass().addClass("even");
					}	
				}
				var quesOptTableTrTdEle=document.createElement("td");
				var quesOptId="p_"+pid+"_q_"+qid+"_"+(i+1);
				var quesOptEle=null;
				if($.browser.msie){
					quesOptEle=document.createElement("<input type='radio' name='"+quesOptName+"'>");
				}else{
					quesOptEle = document.createElement("input");
					$(quesOptEle).attr({
						id:quesOptId,
						name:quesOptName,
						type:"radio"
					})
				}
				var quesOptLabelEle=document.createElement("label");
				$(quesOptLabelEle).attr("for",quesOptId).text(n.content);
				
				$(quesOptTableTrTdEle).append(quesOptEle).append(quesOptLabelEle);
				$(quesOptTableTrEle).append(quesOptTableTrTdEle);
				$(quesOptTableEle).append(quesOptTableTrEle);
			});
			
			$(quesOptConEle).append(quesOptTableEle);
			$(quesConEle).append(quesOptConEle);
			return quesConEle;
		}
	};
	// 多选（checkbox）
	$.render.renderMultiSelectQuesOpt={
		defaultClass:"multi_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderMultiSelectQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderMultiSelectQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderMultiSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			quesTypeOption.columnNumber=1;
			return $.render.renderMultiSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			quesTypeOption.columnNumber=5;
			return $.render.renderMultiSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			var quesType=quesTypeOption.quesType;
			
			var quesConEle=document.createElement("div");
			$(quesConEle).attr({
				pid:pid,
				qid:qid
			}).addClass($.render.renderSingleSelectQuesOpt.defaultClass);
			
			// 问题title
			var quesTitleConEle=document.createElement("h4");
			$(quesTitleConEle).addClass("title dashed_line");
			var quesTitleSubjectEle=document.createElement("span");
			$(quesTitleSubjectEle).text(quesMess.title).addClass("subject");
			var quesTitleRequireEle=document.createElement("span");
			$(quesTitleRequireEle).text("*").css({
				"margin-left": "5px"
			}).addClass("require");
			$(quesTitleConEle).append(quesTitleSubjectEle).append(quesTitleRequireEle);
			$(quesConEle).append(quesTitleConEle);
			// 问题说明
			var quesIntroEle=document.createElement("div");
			$(quesIntroEle).addClass("intro");
			if($.util.isNotEmpty(quesMess.intro)){
				$(quesIntroEle).html(quesMess.intro).show();
			}else{
				$(quesIntroEle).hide();
			}
			$(quesConEle).append(quesIntroEle);
			
			// 问题选项
			var quesOptConEle=document.createElement("div");
			$(quesOptConEle).addClass("content");
			
			var quesOptTableEle=document.createElement("table");
			$(quesOptTableEle).addClass("options");
			var quesOptTableColGroupEle=document.createElement("colgroup");
			var quesOptionMessList=quesMess.quesOptionMessList;
			var quesOptionMessLen=quesOptionMessList.length;
			if($.util.isEmpty(quesTypeOption.columnNumber)){
				quesTypeOption.columnNumber=5;
			}
			var tempColNum=quesOptionMessLen/quesTypeOption.columnNumber;
			var colNum=quesTypeOption.columnNumber;
			if(tempColNum<1){
				colNum=quesOptionMessLen;
			}
			var colWidthRatio=100/colNum;
			for(var i=0;i<colNum;i++){
				var quesOptTableColGroupColEle=document.createElement("col");
				$(quesOptTableColGroupColEle).attr("width",colWidthRatio+"%");
				$(quesOptTableColGroupEle).append(quesOptTableColGroupColEle);
			}
			$(quesOptTableEle).append(quesOptTableColGroupEle);
			
			var quesOptName="p_"+pid+"_q_"+qid;
			var quesOptTableTrEle=null;
			$.each(quesOptionMessList,function(i,n){
				if(i%colNum==0){
					quesOptTableTrEle=document.createElement("tr");
					$(quesOptTableTrEle).attr({
						valign:"top"
					});
					if(i%2==0){
						$(quesOptTableTrEle).removeClass().addClass("odd");
					}else{
						$(quesOptTableTrEle).removeClass().addClass("even");
					}	
				}
				var quesOptTableTrTdEle=document.createElement("td");
				var quesOptId="p_"+pid+"_q_"+qid+"_"+(i+1);
				var quesOptEle=null;
				if($.browser.msie){
					quesOptEle=document.createElement("<input type='checkbox' name='"+quesOptName+"'>");
				}else{
					quesOptEle = document.createElement("input");
					$(quesOptEle).attr({
						id:quesOptId,
						name:quesOptName,
						type:"checkbox"
					})
				}
				var quesOptLabelEle=document.createElement("label");
				$(quesOptLabelEle).attr("for",quesOptId).text(n.content);
				
				$(quesOptTableTrTdEle).append(quesOptEle).append(quesOptLabelEle);
				$(quesOptTableTrEle).append(quesOptTableTrTdEle);
				$(quesOptTableEle).append(quesOptTableTrEle);
			});
			
			$(quesOptConEle).append(quesOptTableEle);
			$(quesConEle).append(quesOptConEle);
			return quesConEle;
		}
	};
	// 单选下拉框（select）
	$.render.renderDefaultSelectQuesOpt={
		defaultClass:"default_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderDefaultSelectQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderDefaultSelectQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderDefaultSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			return $.render.renderDefaultSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			return $.render.renderDefaultSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			var quesType=quesTypeOption.quesType;
			
			var quesConEle=document.createElement("div");
			$(quesConEle).attr({
				pid:pid,
				qid:qid
			}).addClass($.render.renderSingleSelectQuesOpt.defaultClass);
			
			// 问题title
			var quesTitleConEle=document.createElement("h4");
			$(quesTitleConEle).addClass("title dashed_line");
			var quesTitleSubjectEle=document.createElement("span");
			$(quesTitleSubjectEle).text(quesMess.title).addClass("subject");
			var quesTitleRequireEle=document.createElement("span");
			$(quesTitleRequireEle).text("*").css({
				"margin-left": "5px"
			}).addClass("require");
			$(quesTitleConEle).append(quesTitleSubjectEle).append(quesTitleRequireEle);
			$(quesConEle).append(quesTitleConEle);
			// 问题说明
			var quesIntroEle=document.createElement("div");
			$(quesIntroEle).addClass("intro");
			if($.util.isNotEmpty(quesMess.intro)){
				$(quesIntroEle).html(quesMess.intro).show();
			}else{
				$(quesIntroEle).hide();
			}
			$(quesConEle).append(quesIntroEle);
			
			// 问题选项
			var quesOptConEle=document.createElement("div");
			$(quesOptConEle).addClass("content");
			
			var quesOptionMessList=quesMess.quesOptionMessList;
			
			var quesOptName="p_"+pid+"_q_"+qid;
			var quesOptSelectEle=null;
			if($.browser.msie){
				quesOptSelectEle=document.createElement("<select id='"+quesOptName+"' name='"+quesOptName+"'>");
			}else{
				quesOptSelectEle = document.createElement("select");
				$(quesOptSelectEle).attr({
					id:quesOptName,
					name:quesOptName,
					type:"checkbox"
				})
			}
			$(quesOptSelectEle).append("<option value='-1'>--请选择--</option>");
			$.each(quesOptionMessList,function(i,n){
				var quesOptId="p_"+pid+"_q_"+qid+"_"+(i+1);
				var quesOptEle= document.createElement("option");;
				$(quesOptEle).attr({
					id:quesOptId,
					value:quesOptId
				}).text(n.content);
				
				$(quesOptSelectEle).append(quesOptEle);
			});
			
			$(quesOptConEle).append(quesOptSelectEle);
			$(quesConEle).append(quesOptConEle);
			return quesConEle;
		}
	};
	
	// 开放题
	$.render.renderFillBlankQuesOpt={
		defaultClass:"default_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderFillBlankQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderFillBlankQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderFillBlankQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			
		}
	};
	
	// 混合单选题（矩阵单选）
	$.render.renderMatrixSingleSelectQuesOpt={
		defaultClass:"matrix_single_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			
		}
	};
	// 混合单选题（矩阵单选）
	$.render.renderMatrixMultiSelectQuesOpt={
		defaultClass:"matrix_multi_select",
		render:function(pid,qid,quesTypeOption,quesMess){
			var directionType=quesTypeOption.directionType;
			if($.optionLayout.vertical==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.verticalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.horizontal==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.horizontalImpl(pid,qid,quesTypeOption,quesMess);
			}else if($.optionLayout.custom==directionType){
				return $.render.renderMatrixSingleSelectQuesOpt.customImpl(pid,qid,quesTypeOption,quesMess);
			}
		},
		// 竖向
		verticalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 横向
		horizontalImpl:function(pid,qid,quesTypeOption,quesMess){
			
		},
		// 自定义
		customImpl:function(pid,qid,quesTypeOption,quesMess){
			
		}
	};
})(jQuery);