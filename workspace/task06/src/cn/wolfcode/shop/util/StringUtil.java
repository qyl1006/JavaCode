package cn.wolfcode.shop.util;

public abstract class StringUtil {
	public static boolean hasLenngth(String str){
		return str != null && str.trim().length() > 0;
	}
	public static String empty2Null(String str){
		return hasLenngth(str) ? str : null;
	}
}
