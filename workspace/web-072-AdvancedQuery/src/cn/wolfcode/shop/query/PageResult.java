package cn.wolfcode.shop.query;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PageResult {
	//两个用户输入的
	private int currentPage;
	private int pageSize;
		
	//两个查询数据库的
	private List<Product> list;
	private Long pageCount;
	
	//三个计算的
	int endPage;
	int prevPage;
	int nextPage;
	
	public PageResult(int currentPage, int pageSize, List<Product> list, Long pageCount){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.pageCount = pageCount;
		
		if(pageCount <= pageSize){
			endPage = 1;
			prevPage = 1;
			nextPage = 1;
			return;
		}
		
		endPage = (int) (pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1);
		prevPage = currentPage > 2 ? currentPage - 1 : 1;
		nextPage = currentPage + 1 < endPage ? currentPage + 1 : endPage;
	}
}
