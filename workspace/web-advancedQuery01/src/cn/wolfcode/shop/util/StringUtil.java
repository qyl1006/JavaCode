package cn.wolfcode.shop.util;

public abstract class StringUtil {
	//判断字符串是否为有值
	public static boolean haslength(String str){
		return str != null && str.trim().length() > 0;
	}
	
	//把为空字符串转为null
	public static String emptyToNull(String str){
		return haslength(str) ? str : null;
	}
}
