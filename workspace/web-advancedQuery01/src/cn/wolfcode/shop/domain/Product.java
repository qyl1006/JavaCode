package cn.wolfcode.shop.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Product {
	private Long uid;
	private String uproductName;
	private Long udir_id;
	private BigDecimal usalePrice;
	private String usupplier;
	private String ubrand;
	private BigDecimal ucutoff;
	private BigDecimal ucosPrice;
}
