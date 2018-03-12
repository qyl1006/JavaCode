package cn.wolfcode.shop.query;

import cn.wolfcode.shop.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserQueryObject {
	//用户输入的
	private int currentPage = 1;
	private int pageSize = 2;
	
	private String name;
	
	public String getName(){
		return StringUtil.Empty2Null(name);
	}
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
}
