package cn.colfcode.shop.test;

import java.math.BigDecimal;

import org.junit.Test;

import cn.colfcode.shop.dao.IProductDAO;
import cn.colfcode.shop.dao.impl.ProductDAOImpl;
import cn.colfcode.shop.domain.Product;
import cn.colfcode.shop.query.ProductQueryObject;
import cn.colfcode.shop.service.IProductService;
import cn.colfcode.shop.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	private IProductService service = new ProductServiceImpl();
	private IProductDAO dao = new ProductDAOImpl();
	
	
	@Test
	public void testSave() {
		Product p = new Product(null, "测试更新04", null, null);
		service.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product(17L, "测试更新05", null, null);
		service.update(p);
	}

	@Test
	public void testDel() {
		service.delete(17L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(14L));
	}
	@Test
	public void testQueryCount() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setKeyWord("测试");
		qo.setMinPrice(new BigDecimal("11110"));
		qo.setMaxPrice(new BigDecimal("11111"));
		System.out.println(dao.queryCount(qo));
	}
	@Test
	public void testQuery() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setKeyWord("测试");
		qo.setMinPrice(new BigDecimal("11110"));
		qo.setMaxPrice(new BigDecimal("11111"));
		
		dao.query(qo).forEach(System.out::println);
	}

}