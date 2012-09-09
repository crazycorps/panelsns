/**
 * 跟问卷相关的信息放到此
 */
(function($) {
	// 问卷问题类型
	$.quesType={
		// 单选（radio）
		singleSelect:1,
		// 多选（checkbox）
		multiSelect:2,
		// 下拉框单选
		select:3,
		// 填空题（开放题）
		fillBlank:4,
		// 混合单选题（矩阵单选）
		matrixSingleSelect:5,
		// 混合获选题（矩阵多选）
		matrixMultiSelect:6
	};
	$.optionLayout={
		vertical:1,
		horizontal:2,
		custom:3
	};
})(jQuery);