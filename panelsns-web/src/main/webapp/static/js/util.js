jQuery(function($) {
	$.util = {};
	$.util.isEmpty = function(str){
		return !$.util.isNotEmpty(str);
	};
	$.util.isNotEmpty = function(str){
		if(str==null||str==undefined||str==""||$.util.getStringLength(str)==0){
			return false;
		}
		return true;
	};
	$.util.getStringLength = function(str) {
		str = $.trim(str);
		if (str == "") {
			return 0;
		}
		var length = 0;
		for ( var i = 0; i < str.length; i++) {
			if (str.charCodeAt(i) > 255) {
				length += 2;
			} else {
				length++;
			}
		}
		return length;
	};
	$.util.getLengthString = function(str, length, isSpace) {
		if (arguments.length < 3) {
			var isSpace = true;
		}

		if ($.trim(str) == "") {
			return "";
		}

		var tempStr = "";
		var strLength = 0;
		for ( var i = 0; i < str.length; i++) {
			if (str.charCodeAt(i) > 255) {
				strLength += 2;
			} else {
				if (str.charAt(i) == " ") {
					if (isSpace) {
						strLength++;
					}
				} else {
					strLength++;
				}
			}
			if (length >= strLength) {
				tempStr += str.charAt(i);
			}
		}
		return tempStr;
	};
	$.util.checkRequire = function(value) {
		var reg = /.+/;
		return reg.test($.trim(value));
	};
	$.util.minLength = function(value, length, isByte) {
		var strLength = $.trim(value).length;
		if (isByte) {
			strLength = $.util.getStringLength(value);
		}
		return strLength >= length;
	};
	$.util.maxLength = function(value, length, isByte) {
		var strLength = $.trim(value).length;
		if (isByte) {
			strLength = $.util.getStringLength(value);
		}
		return strLength <= length;
	};
	$.util.rangeLength = function(value, minLength, maxLength, isByte) {
		var strLength = $.trim(value).length;
		if (isByte) {
			strLength = $.util.getStringLength(value);
		}
		return strLength >= minLength && strLength <= maxLength;
	};
	$.util.checkMobilePhone = function(value) {
		return /^(13\d{9}|18\d{9}|15\d{9})$/i.test($.trim(value));
	};
	$.util.checkPhone = function(val) {
		var flag = 0;
		val = $.trim(val);
		var num = ".0123456789/-()";
		for ( var i = 0; i < (val.length); i++) {
			tmp = val.substring(i, i + 1);
			if (num.indexOf(tmp) < 0) {
				flag++;
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	};
	$.util.checkEmail = function(val) {
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		return reg.test(val);
	};
	$.util.checkUrl = function(val) {
		var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
				+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
				+ "(([0-9]{1,3}.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
				+ "|" // 允许IP和DOMAIN（域名）
				+ "([0-9a-z_!~*'()-]+.)*" // 域名- www.
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]." // 二级域名
				+ "[a-z]{2,6})" // first level domain- .com or .museum
				+ "(:[0-9]{1,4})?" // 端口- :80
				+ "((/?)|" // a slash isn't required if there is no file name
				+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
		var re = new RegExp(strRegex);
		// re.test()
		if (re.test(val)) {
			return (true);
		} else {
			return (false);
		}
	};
	$.util.checkCurrency = function(val) {
		var reg = /^\d+(\.\d+)?$/;
		return reg.test(val);
	};
	$.util.checkNumber = function(val) {
		var reg = /^\d+$/;
		return reg.test(val);
	};
	$.util.checkInteger = function(val) {
		var reg = /^[-\+]?\d+$/;
		return reg.test(val);
	};
	$.util.checkDouble = function(val) {
		var reg = /^[-\+]?\d+(\.\d+)?$/;
		return reg.test(val);
	};
	$.util.checkPrice = function(val) {
		var reg = /^\d+(\.\d+)?$/;
		return reg.test(val);
	};
	$.util.checkEnglish = function(val) {
		var reg = /^[A-Za-z]+$/;
		return reg.test(val);
	};
	$.util.checkQQMsn = function(val) {
		var reg = /^[1-9]*[1-9][0-9]*$|^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$.util/;
		return reg.test(val);
	};
	$.util.getClickIsElement = function(obj, event) {
		var offset = obj.offset();
		var minX = offset.left;
		var minY = offset.top;
		var maxX = minX + obj.width();
		var maxY = minY + obj.height();
		if (event.pageX < minX || event.pageX > maxX || event.pageY < minY
				|| event.pageY > maxY) {
			return false;
		} else {
			return true;
		}
	};
});
