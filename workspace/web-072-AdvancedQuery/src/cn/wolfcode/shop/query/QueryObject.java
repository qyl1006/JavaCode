package cn.wolfcode.shop.query;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class QueryObject {
	//两个用户输入的--分页的,并给默认值
	private int currentPage = 1;
	private int pageSize = 3;
		
	//提供一个属性,用于分页查询的开始值获取
	public int getStartIndex(){
		return (currentPage - 1) * pageSize;
	}
}
