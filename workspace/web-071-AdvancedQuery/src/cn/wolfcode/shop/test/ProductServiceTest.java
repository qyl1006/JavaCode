package cn.wolfcode.shop.test;

import java.util.List;

import org.junit.Test;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.service.IProductService;
import cn.wolfcode.shop.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	private IProductService ps = new ProductServiceImpl();
	
	
	@Test
	public void testSave() {
		Product p = new Product();
		p.setUproductName("测试保存");
		ps.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setUproductName("测试更新");
		p.setUid(37L);
		ps.update(p);
	}

	@Test
	public void testDelete() {
		ps.delete(34L);
		ps.delete(36L);
	}

	@Test
	public void testGet() {
		Product product = ps.get(3L);
		System.out.println(product);
	}

	@Test
	public void testListAll() {
		List<Product> list = ps.listAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testAdvancedQuery(){
		ProductQueryObject qo = new ProductQueryObject();
//		qo.setProductName("9");
//		qo.setMinSalePrice(new BigDecimal("100"));
//		qo.setMaxSalePrice(new BigDecimal("1000"));
//		qo.setDir_id(3L);
		
		//传入分页的两个参数
//		qo.setCurrentPage(7);
//		qo.setPageSize(3);
		
		List<Product> list = ps.query(qo);
		Long totalCount = ps.queryCount(qo);
//		
		PageResult result = new PageResult(qo.getCurrentPage(), qo.getCurrentPage(), list, totalCount);
		List<Product> test = result.getList();
		test.forEach(System.out::println);
		
		System.out.println("总记录数" + totalCount);
		System.out.println("当前页:" + result.getCurrentPage());
		System.out.println("上一页:" + result.getPrevPage());
		System.out.println("下一页:" + result.getNextPage());
		System.out.println("尾页:" + result.getEndPage());
		System.out.println("上一页:" + result.getPrevPage());
		System.out.println("页面容量:" + result.getPageSize());
	}
	
	@Test
	public void TestQueryOrCount(){
		ProductQueryObject qo = new ProductQueryObject();
		qo.setProductName("罗技M90  ");
//		qo.setMinSalePrice(new BigDecimal("100"));
////		qo.setMaxSalePrice(new BigDecimal("1000"));
//		qo.setDir_id(3L);
//		
//		//传入分页的两个参数
//		qo.setCurrentPage(1);
//		qo.setPageSize(4);
//		
		List<Product> list = ps.query(qo);
		list.forEach(System.out::println);
		
		Long totalCount = ps.queryCount(qo);
		System.out.println("总记录数" + totalCount);
		
	}
}
