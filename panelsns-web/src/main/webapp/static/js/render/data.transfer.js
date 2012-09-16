/**
 * 跟问卷相关的信息放到此
 */
(function($) {
	$(document).ready(function(){
		$.transfer.init();
	});
	$.transfer={
		surveyId:-1,
		naireId:-1,
		nowPageNo:1,
		init:function(){
			var surveyIdEle=$("#surveyId");
			if(surveyIdEle.length>0){
				$.transfer.surveyId=parseInt(surveyIdEle.val());
			}
			var naireIdEle=$("#naireId");
			if(naireIdEle.length>0){
				$.transfer.naireId=parseInt(naireIdEle.val());
			}
			var nowPageNoEle=$("#nowPageNo");
			if(nowPageNoEle.length>0){
				$.transfer.nowPageNo=parseInt(nowPageNoEle.val());
			}
			// 默认加载传入的第几页信息
			$.transfer.transfe($.transfer.naireId,$.transfer.nowPageNo);
			$.transfer.initEvents();
		},
		initEvents:function(){
			$(".survey_next").click($.transfer.nextPageEvent);
		},
		nextPageEvent:function(event){
			$.transfer.transfe($.transfer.naireId,$.transfer.nowPageNo+1);
		},
		transfe:function(naireId,pageNo){
			var datas={
				naireId:naireId,
				pageNo:pageNo
			};
			$.ajax({
			   type: "POST",
			   url: "/u/naire/mess/",
			   data: $.param(datas),
			   dataType:"JSON",
			   success: function(ret){
				   var proStatus=ret.p_s;
				   if(proStatus==0){
					   var pageMess=ret.pageMess.pageMess;
					   $.transfer.nowPageNo=pageNo;
					   $.transfer.rendPageMess(pageMess);
				   }else{
					   
				   }
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
			   }
			});
		},
		rendPageMess:function(pageMess){
			if(pageMess==undefined||pageMess==null){
				return ;
			}
			var nowPageNo=$.transfer.nowPageNo;
			var nowPageMess=pageMess["p_"+nowPageNo];
			if(nowPageMess==undefined||nowPageMess==null){
				return ;
			}
			var pageContent=$(".render_body .survey_body .survey_page_body .survey_page_content ");
			$(pageContent).empty();
			$.each(nowPageMess,function(qid,quesAllMess){
				var quesTypeOption=quesAllMess.quesTypeOption;
				var quesMess=quesAllMess.quesMess;
				var qNo=qid.substr(2);
				var generatedQuesEle=$.render.render(nowPageNo,qNo,quesTypeOption,quesMess);
				if(generatedQuesEle==null||generatedQuesEle==undefined){
					return ;
				}
				var liEle=document.createElement("li");
				$(liEle).attr({
					qid:qNo,
					t:quesTypeOption.quesType
				}).addClass("part");
				$(liEle).append(generatedQuesEle);
				$(pageContent).append(liEle);
			});
		}
	};
	
})(jQuery);