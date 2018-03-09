package cn.wolfcode.shop.query;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import lombok.Getter;

//分页查询后所有数据封装的对象
@Getter
public class PageResult {
	//用户输入的
	private int currentPage;
	private int pageSize;    //页面容量
	
	//数据库查询的
	private List<Product> list;
	private Long totalCount;  //总记录数
	
	//三个计算出来的
	private int endPage;
	private int prevPage;
	private int nextPage;
	
	public PageResult(int currentPage, int pageSize, List<Product> list, Long totalCount){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.totalCount = totalCount;
		
		if(totalCount <= pageSize){
			endPage = 1;
			prevPage = 1;
			nextPage = 1;
			return;
		}
		endPage = (int) (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
		prevPage = currentPage > 1 ? currentPage - 1 : 1;
		nextPage = currentPage + 1 < endPage ? currentPage + 1 : endPage;
	}
}
