package cn.wolfcode.shop.query;

import cn.wolfcode.shop.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserQueryObject {
	private int currentPage = 1;
	private int pageSize = 3;
	
	private String name;
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
	
	public String getName(){
		return StringUtil.Empty2Null(name);
	}
}
