package cn.wolfcode.shop.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
	private Long id;
	private String name;
	private BigDecimal price;
	private String info;
}
