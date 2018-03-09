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
	public void teestAdvancedQuery() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setProductName("m");
		qo.setCurrentPage(1);;
		
		PageResult result = ps.advancedQuery(qo);
		List<Product> list = result.getList();
		list.forEach(System.out::println);
		
		System.out.println("-------------------------------------------------");
		System.out.println("当前页:" + result.getCurrentPage());
		System.out.println("页面容量: " + result.getPageSize());
		System.out.println("上一页:" + result.getPrevPage());
		System.out.println("下一页:" + result.getNextPage());
		System.out.println("尾页:" + result.getEndPage());
		System.out.println("记录数:" + result.getPageCount());
	}
	

}
