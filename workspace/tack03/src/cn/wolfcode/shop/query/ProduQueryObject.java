package cn.wolfcode.shop.query;

import java.math.BigDecimal;

import cn.wolfcode.shop.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProduQueryObject {
	private int currentPage = 1;
	private int pageSize = 2;
	
	private String keyWord;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
	
	public String getKeyWord(){
		return StringUtil.Empty2Null(keyWord);
	}
}
