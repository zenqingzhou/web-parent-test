package com.bidewu.web.common.utils;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	/** Default path separator: "/" */
	public static final String pathSeparator = "/";

	/**
	 * js保留2位小数（强制） 四舍五入 并补齐不足的位数 对于小数点位数大于2位的，用上面的函数没问题，但是如果小于2位的，比如：
	 * changeTwoDecimal(3.1)，将返回 3.1，如果你一定需要3.10这样的格式，那么需要下面的这个函数：
	 * 功能：将浮点数四舍五入，取小数点后2位，如果不足2位则补0,这个函数返回的是字符串的格式
	 * 用法：changeTwoDecimal(3.1415926) 返回 3.14 changeTwoDecimal(3.1) 返回 3.10
	 *
	 * @throws GeneralSecurityException
	 */
	public static String changeTwoDecimal_f(String x) {
		if (StringTool.isEmpty(x)) {
			return null;
		}

		BigDecimal b = new BigDecimal(x);
		Double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		String s_x = f1.toString();
		int pos_decimal = s_x.indexOf(".");
		if (pos_decimal < 0) {
			pos_decimal = s_x.length();
			s_x += '.';
		}
		while (s_x.length() <= pos_decimal + 2) {
			s_x += '0';
		}
		return s_x;
	}

	/**
	 * 检查手机
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean checkPhoneNum(String mobile) {
		if (mobile == null) {
			return false;
		}
		String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(mobile));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查手机或电话
	 *
	 * @param phoneandmobile
	 * @return
	 */
	public static boolean checkPhoneAndMobileNum(String phoneandmobile) {
		if (phoneandmobile == null) {
			return false;
		}
		String regex = "(^(((18[0-9]{1})|(13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1}))+\\d{8})$)|(^\\d{3,4}-?\\d{7,9}$)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneandmobile);
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查邮箱
	 *
	 * @return
	 */
	public static boolean checkEmail(String str) {
		if (str == null) {
			return false;
		}
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查密码 由位数字或字母组成
	 *
	 * @param str
	 *            密码
	 * @param start
	 *            起始位数
	 * @param end
	 *            结束位数
	 * @author MengTao
	 * @return
	 */
	public static boolean checkPassWord(String str, int start, int end) {
		if (str == null) {
			return false;
		}
		String regex = "^[a-z0-9A-Z]{" + start + "," + end + "}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 检查密码 由位数字与字母组成
	 *正则表达式：
	 1.8~20位同时包含数字和大小写字母    (?![0-9A-Z]+$)(?![0-9a-z]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$
	 2.8~20位同时包含数字和字母
	 ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$
	 * @param str
	 *            密码
	 * @author MengTao
	 * @return
	 */
	public static boolean checkUserPassWord(String str) {
		if (str == null) {
			return false;
		}
		String regex = "(?![0-9A-Z]+$)(?![0-9a-z]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Title: 会员名是否合法检测<br/>
	 * Description: <br />
	 *
	 * @author
	 * @date 2014年7月30日 下午5:34:14
	 * @param str
	 * @param minLength
	 * @param maxLength
	 * @return
	 */
	public static boolean checkUserName(String str,int minLength,int maxLength){
	    if(StringTool.isBlank(str)){
	        return false;
	    }
	    String regex = "^[a-z0-9A-Z_-]{" + minLength + "," + maxLength + "}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(StringTool.nullToString(str));
        if (!m.find()) {
            return false;
        } else {
            return true;
        }
	}

	/**
	 * 检查枚举类型EMoney后半部分1,3,5,10,12@10
	 *
	 * @return
	 */
	public static boolean checkEMoney(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = "^[\\d,]+@?[0-9\\.]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkEMoneyRange(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = "^[\\d-]+@?[0-9\\.]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 不是EMAIL并且不是手机格式的字符串 返回TRUE
	 *
	 * @param str
	 */
	public static Boolean isNotEmailAndPhone(String str) {
		if (str == null) {
			return false;
		}
		if ((!checkEmail(StringTool.nullToString(str)) && !checkPhoneNum(StringTool
				.nullToString(str)))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查time yyyymmddhhmmss
	 *
	 * @return
	 */
	public static boolean checkIsTime(String str) {
		if (str == null) {
			return false;
		}
		String regex = "^\\d{14}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查是不是数字组成
	 *
	 * @return
	 */
	public static boolean checkIsNum(String str) {
		if (str == null) {
			return false;
		}
		String regex = "^[0-9]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查是不是 IP
	 *
	 * @return
	 */
	public static boolean isIp(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = "^(([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.)(([0-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.){2}([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查是不是金额 支持3位小数
	 *
	 * @return
	 */
	public static boolean isAcount(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		BigDecimal gBigDecimal = new BigDecimal(str);
		str = gBigDecimal.toPlainString();
		String regex = "^((-)([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,3})|(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,3})?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查 3位小数或者整数 返回TRUE 否则返回FALSE
	 *
	 * @return
	 */
	public static boolean isAcountAndNum(String str) {
		if (isAcount(str) || checkIsNum(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断str是否包含数字
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		String regex = "[0-9]+?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.find() == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证邮编
	 *
	 * @param post
	 * @return
	 */
	public static boolean checkPost(String post) {
		if (post.matches("[0-9]\\d{5}(?!\\d)")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查枚举类型规则正确性
	 *
	 * @return
	 */
	public static boolean checkEnumRuleReg(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = "^.+#\\w+:.+(@.+)?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 验证QQ
	 *
	 * @param qq
	 * @return
	 */
	public static boolean checkQQ(String qq) {
		if (StringTool.isEmpty(qq)) {
			return false;
		}
		Pattern p1 = Pattern.compile("[1-9][0-9]{4,14}");
		Matcher m1 = p1.matcher(qq);
		if (m1.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证身份证号
	 *
	 * @param idCard
	 * @return
	 */
	public static boolean checkIdCard(String idCard) {
		if (idCard.length() != 15 && idCard.length() != 18) {
			return false;
		}
		//String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
		String regex1 = "^(\\d{17}([0-9]|X))$";
		return Pattern.matches(regex1, idCard);
	}

	/**
	 * 验证固定电话
	 *
	 * @param telephone
	 * @return
	 */
	public static boolean checkTelephone(String telephone) {
		if (StringTool.isEmpty(telephone)) {
			return false;
		}
		if (telephone.indexOf("@") != -1 || telephone.indexOf(".") != -1
				|| telephone.indexOf("_") != -1) {
			return false;
		}
		Pattern p1 = Pattern.compile("[\\w|\\.|-]*");
		Matcher m1 = p1.matcher(telephone);
		if (m1.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查是不是金额 支持2位小数
	 *
	 * @return
	 */
	public static boolean isDoubleWithTwoNum(String str) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查联名卡正面，最多为8个汉字
	 *
	 * @param cardBefore
	 * @return
	 */
	public static boolean checkCardBefore(String cardBefore) {
		String regex = "^[\u4e00-\u9fa5]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(cardBefore));
		if (cardBefore.length() > 8) {
			return false;
		} else {
			if (!m.find()) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 检查联名卡背面，最多为30个汉字
	 *
	 * @param cardBefore
	 * @return
	 */
	public static boolean checkCardAfter(String cardBefore) {
		String regex = "^[\u4e00-\u9fa5]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(cardBefore));
		if (cardBefore.length() > 30) {
			return false;
		} else {
			if (!m.find()) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean checkTrueName(String trueName) {
		String regex = "^[\u4e00-\u9fa5]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(trueName));
		if (trueName.length() < 2 || trueName.length() > 4) {
			return false;
		} else {
			if (!m.find()) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * <p>
	 * Title: HTML相关的正则表达式工具类
	 * </p>
	 * <p>
	 * Description: 包括过滤HTML标记，转换HTML标记，替换特定HTML标记
	 * </p>
	 * <p>
	 * Copyright: Copyright (c) 2006
	 * </p>
	 *

	 */

	private final static String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签

	private final static String regxpForImgTag = "<\\s*img\\s+([^>]*)\\s*>"; // 找出IMG标签

	private final static String regxpForImaTagSrcAttrib = "src=\"([^\"]+)\""; // 找出IMG标签的SRC属性

	/**
	 *
	 * 基本功能：替换标记以正常显示
	 * <p>
	 *
	 * @param input
	 * @return String
	 */
	public String replaceTag(String input) {
		if (!hasSpecialChars(input)) {
			return input;
		}
		StringBuffer filtered = new StringBuffer(input.length());
		char c;
		for (int i = 0; i <= input.length() - 1; i++) {
			c = input.charAt(i);
			switch (c) {
			case '<':
				filtered.append("&lt;");
				break;
			case '>':
				filtered.append("&gt;");
				break;
			case '"':
				filtered.append("&quot;");
				break;
			case '&':
				filtered.append("&amp;");
				break;
			default:
				filtered.append(c);
			}

		}
		return (filtered.toString());
	}

	/**
	 *
	 * 基本功能：判断标记是否存在
	 * <p>
	 *
	 * @param input
	 * @return boolean
	 */
	public boolean hasSpecialChars(String input) {
		boolean flag = false;
		if ((input != null) && (input.length() > 0)) {
			char c;
			for (int i = 0; i <= input.length() - 1; i++) {
				c = input.charAt(i);
				switch (c) {
				case '>':
					flag = true;
					break;
				case '<':
					flag = true;
					break;
				case '"':
					flag = true;
					break;
				case '&':
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 *
	 * 基本功能：过滤所有以"<"开头以">"结尾的标签
	 * <p>
	 *
	 * @param str
	 * @return String
	 */
	public static String filterHtml(String str) {
		Pattern pattern = Pattern.compile(regxpForHtml);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	// 过滤URL无效数据
	public static String filterUrl(String str) {
		if (StringTool.isEmpty(str)) {
			return str;
		} else {
			str = str.replaceAll("<", "").replaceAll(">", "");
			str = str.replaceAll("'", "");
			str = str.replaceAll("\"", "");
			str = str.replaceAll("eval\\((.*)\\)", "");
			str = str.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"");
			str = str.replaceAll("script", "");
			str = str.replaceAll("alert", "");
			return str;
		}
	}

	/**
	 * Xss 过滤替换
	 *
	 * @param value
	 * @return
	 */
	public static String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\"", "");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("script", "");
		return value;
	}

	/**
	 * Xss 后台过滤替换
	 *
	 * @param value
	 * @return
	 */
	public static String cleanXSSManager(String value) {
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;");
		// value = value.replaceAll("\\(", "& #40;").replaceAll("\\)",
		// "& #41;");
		value = value.replaceAll("\"", "");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("script", "");
		return value;
	}

	public static void main(String[] args) {

		/*String aa = "http://aa.action?name=\"yanzi\" omove=\"alert(1)\"";

		System.out.println(new RegexUtils().cleanXSS(aa));*/
		//System.out.println(RegexUtils.checkUserPassWord("Zhw123456"));

		System.out.println(RegexUtils.checkIdCard("110105198904222222"));
	}



	/**
	 *
	 * 基本功能：过滤指定标签
	 * <p>
	 *
	 * @param str
	 * @param tag
	 *            指定标签
	 * @return String
	 */
	public static String fiterHtmlTag(String str, String tag) {
		String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 检查枚举模板的 传入正则
	 *
	 * @return
	 */
	public static boolean checkRegStr(String str, String regstr) {
		if (StringTool.isEmpty(str)) {
			return false;
		}
		String regex = regstr;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(StringTool.nullToString(str));
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}



}
