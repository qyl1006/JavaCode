package cn.wolfcode.smis.query;

import java.util.Collections;
import java.util.List;

import cn.wolfcode.smis.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PageResult {
	@SuppressWarnings("unchecked")
	public static PageResult EMPTY_PAGE = new PageResult(1, 1, 0L, Collections.EMPTY_LIST);
	
	private int currentPage;
	private int pageSize;
	
	private Long pageCount;
	private List<Product> data;
	
	private int endPage;
	private int prevPage;
	private int nextPage;
	public PageResult(int currentPage, int pageSize, Long pageCount,
			List<Product> data) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.data = data;
		
		if(pageCount <= pageSize){
			endPage = 1;
			prevPage = 1;
			nextPage = 1;
			return;
		}
		
		endPage = (int) (pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1);
		prevPage = currentPage > 2 ? currentPage - 1 : 1;
		nextPage = currentPage < endPage ? currentPage + 1 : endPage;
	}
	
}
