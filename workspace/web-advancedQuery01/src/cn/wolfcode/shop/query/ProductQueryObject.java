package cn.wolfcode.shop.query;

import java.math.BigDecimal;

import cn.wolfcode.shop.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductQueryObject {
	//用户输入的
	private int currentPage = 1;
	private int pageSize = 3;
	
	//多条件查询
	private String productName;
	private BigDecimal minsalePrice;
	private BigDecimal maxsalePrice;
	
	private String brand;
	private Long dir_id;
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
	
	public String getProductName(){
		return StringUtil.emptyToNull(productName);
	}
//	public String getBrand(){
//		return StringUtil.emptyToNull(brand);
//	}
	
}
