package cn.wlfcode.shop.util;

public abstract class StringUtil {
	public static boolean HasLength(String str){
		return str != null && str.trim().length() > 0;
	}
	public static String Empty2Null(String str){
		return HasLength(str) ? str : null;
	}
}
