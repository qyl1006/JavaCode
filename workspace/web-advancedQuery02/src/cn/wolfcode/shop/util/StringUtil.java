package cn.wolfcode.shop.util;

public abstract class StringUtil {
	public static boolean haslength(String str){
		return str != null && str.trim().length() > 0;
	}
	
	public static String Empty2Null(String str){
		return haslength(str) ? str : null;
	}
}
