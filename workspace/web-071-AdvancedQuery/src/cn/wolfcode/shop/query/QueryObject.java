package cn.wolfcode.shop.query;

import lombok.Getter;
import lombok.Setter;

//通用查询模板
@Setter @Getter
public class QueryObject {
	//分页查询默认值
	private int currentPage = 1;
	private int pageSize = 3;
	
	//提供一个属性,用于分页查询的开始值获取
	public int getStartIndex(){
		
		return (currentPage - 1) * pageSize;
	}
	
}
