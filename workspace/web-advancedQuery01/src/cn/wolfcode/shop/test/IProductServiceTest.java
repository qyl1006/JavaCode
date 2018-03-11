package cn.wolfcode.shop.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.service.IProductService;
import cn.wolfcode.shop.service.impl.ProductServiceImpl;

public class IProductServiceTest {
	private IProductService service = new ProductServiceImpl();
	
	@Test
	public void testSave() {
		Product p = new Product();
		p.setUproductName("测试保存");
		service.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setUid(46L);
		p.setUproductName("测试更新");
		service.update(p);
	}

	@Test
	public void testDelete() {
		service.delete(45L);
	}

	@Test
	public void testGet() {
		Product product = service.get(2L);
		System.out.println(product);
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryCount() {
		fail("Not yet implemented");
	}

}