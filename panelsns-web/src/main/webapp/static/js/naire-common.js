/**
 * 跟问卷相关的信息放到此
 */
(function($) {
	// 问卷问题类型
	$.quesType={
		singleSelect:1,
		multiSelect:2,
		select:3,
		fillBlank:4,
		matrixSelect:5
	};
	$.optionLayout={
		vertical:1,
		horizontal:2,
		custom:3
	};
})(jQuery);