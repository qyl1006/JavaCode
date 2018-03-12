package cn.wolfcode.shop.query;

import java.util.Collections;
import java.util.List;

import cn.wolfcode.shop.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class PageResult {
	@SuppressWarnings("unchecked")
	public static PageResult EMTPY_PAGE = new PageResult(1, 1, 0L, Collections.EMPTY_LIST);
	//两个用户输入的
	private int currentPage;
	private int pageSize;;
	
	//两个查询
	private Long pageCount;
	private List<User> data;
	
	//三个计算的
	private int endPage;
	private int prevPage;
	private int nextPage;
	public PageResult(int currentPage, int pageSize, Long pageCount,
			List<User> data) {
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