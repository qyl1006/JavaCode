package cn.wolfcode.shop.util;

public abstract class StringUtil {
	public static boolean hasLength(String str){
		return !(str == null || "".equals(str.trim()));
	}

}
