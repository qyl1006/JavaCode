package cn.wolfcode.shop.test;

import cn.wolfcode.shop.util.StringUtil;

public class Test {
	public static void main(String[] args) {
		String str = "a   ";
		String str2 = "   a  ";
		
		StringUtil.haslength(str);
		StringUtil.haslength(str2);
		System.out.println(str + str2);
	}
}
