	(function($) {
		
		$.editor={
			// 默认单选题
			defaultQuesTypeOption:new QuesTypeOption(true,false,$.quesType.singleSelect,0,0,$.optionLayout.vertical,0,false),
			// 多选题
			multiSelectQuesTypeOption:new QuesTypeOption(true,false,$.quesType.multiSelect,0,0,$.optionLayout.horizontal,0,false),
			defaultQuesOptionMess:new QuesOptionMess(null,"",false,0,0,0,false),
			defaultQuesMess:new QuesMess(null,"新建题目","",[new QuesOptionMess(null,"",false,0,0,0,false),new QuesOptionMess(null,"",false,0,0,0,false)])
		};
	})(jQuery);

	/**
	 * isRequire:是否必填
	 * isHasIntro：是否有特殊说明
	 * quesType：问题类型（单选、多选、下拉菜单）
	 * leastChoice：当选择多线的时候，至少选择多少项
	 * mostChoice：当选择多线的时候，最多选择多少项
	 * directionType：选项排列类型
	 * columnNumber：当选择排列类型为自定义是，每行显示多少列
	 * isShuffle：是否混排
	 */
	function QuesTypeOption(isRequire,isHasIntro,quesType,leastChoice,mostChoice,directionType,columnNumber,isShuffle){
		this.isRequire=isRequire;
		this.isHasIntro=isHasIntro;
		this.quesType=quesType;
		this.leastChoice=leastChoice;
		this.mostChoice=mostChoice;
		this.directionType=directionType;
		this.columnNumber=columnNumber;
		this.isShuffle=isShuffle;
	}
	/**
	 * title:问题标题
	 * intro：问题特殊说明
	 * quesOptionMessList：问题选项列表
	 */
	function QuesMess(sn,title,intro,quesOptionMessList){
		this.sn=sn;
		this.title=title;
		this.intro=intro;
		this.quesOptionMessList=quesOptionMessList;
	}
	
	/**
	 * content:问题选项内容
	 * isBlank：是否可以为空
	 */
	function QuesOptionMess(sn,content,allowSpecify,inputWidth,leastInput,mostInput,isExclusive){
		this.sn=sn;
		this.content=content;
		this.quesOptionControlMess=new QuesOptionControlMess(allowSpecify,inputWidth,leastInput,mostInput,isExclusive);
	}
	/**
	 * 跟问题的QuesTypeOption是一个类型
	 */
	function QuesOptionControlMess(allowSpecify,inputWidth,leastInput,mostInput,isExclusive){
		this.allowSpecify=allowSpecify;
		this.inputWidth=inputWidth;
		this.leastInput=leastInput;
		this.mostInput=mostInput;
		this.isExclusive=isExclusive;
	}