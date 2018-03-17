package cn.wolfcode.shop.query;

import java.math.BigDecimal;

import cn.wolfcode.shop.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @AllArgsConstructor @NoArgsConstructor

public class QueryObject {
	private int currentPage = 1;
	private int pageSize = 2;
	
	private String keyWord;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	
	public int getStart(){
		return (currentPage - 1) * pageSize;
	}
	
	public String getKeyWord(){
		return StringUtil.empty2Null(keyWord);
	}
}
