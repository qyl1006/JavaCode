package cn.wolfcode.shop.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Product {
	private Long uid;
	private String uproductName;
	private Long udir_id;
	private BigDecimal usalePrice;
	private String usupplier;
	private String ubrand;
	private BigDecimal ucutoff;
	private BigDecimal ucostPrice;
}
