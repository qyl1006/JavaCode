package cn.wolfcode.shop.query;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//多添加查询条件
@Setter @Getter @NoArgsConstructor @ToString
public class ProductQueryObject extends QueryObject {
	private String productName;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	
	private String brand;
	private Long dir_id;
	
}
