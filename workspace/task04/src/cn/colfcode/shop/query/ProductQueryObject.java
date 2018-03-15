package cn.colfcode.shop.query;

import java.math.BigDecimal;

import cn.colfcode.shop.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ProductQueryObject {
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
