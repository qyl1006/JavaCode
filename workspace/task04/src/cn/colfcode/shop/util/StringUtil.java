package cn.colfcode.shop.util;

public abstract class StringUtil {
	public static boolean hasLength(String str){
		return str != null && str.trim().length() > 0;
	}

	public static String Empty2Null(String str){
		return hasLength(str) ? str : null;
	}
}
