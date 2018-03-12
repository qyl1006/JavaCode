package cn.wolfcode.shop.query;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PageResult {
	public static final PageResult EMTPY_PAGE = new PageResult(1, 1, 0L, Collections.EMPTY_LIST);
	private int currentPage;
	private int pageSize;
	
	//两个查的
	private Long pageConut;
	private List<?> data;
	
	//三个计算的
	private int endPage;
	private int prevPage;
	private int nextPage;
	

	public PageResult(int currentPage, int pageSize, Long pageConut,
			List<?> data) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageConut = pageConut;
		this.data = data;
		
		if(pageConut <= pageSize){
			endPage = 1;
			prevPage = 1;
			nextPage = 1;
			return;
		}
		endPage = (int) (pageConut % pageSize == 0 ?  pageConut / pageSize : pageConut / pageSize + 1) ;
		prevPage = currentPage > 2 ? currentPage - 1 : 1;
		nextPage = currentPage < endPage ? currentPage + 1 : endPage;
		
	}}
