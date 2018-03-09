package cn.wolfcode.shop.query;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductQueryObject extends QueryObject{
	private String productName;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	
	private String brand;
	private Long dir_id;
	
	
}
