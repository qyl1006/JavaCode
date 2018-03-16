package cn.wlfcode.shop.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import cn.wlfcode.shop.dao.IProductDAO;
import cn.wlfcode.shop.dao.impl.ProductDAOImpl;
import cn.wlfcode.shop.domain.Product;
import cn.wlfcode.shop.query.ProductQueryObject;
import cn.wlfcode.shop.service.IProductService;
import cn.wlfcode.shop.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	private IProductService service = new ProductServiceImpl();
	private IProductDAO dao = new ProductDAOImpl();
	
	
	@Test
	public void testSave() {
		Product p = new Product(null, "测试保存11111", null, null);
		service.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product(20L, "测试更新11111", null, null);
		service.update(p);
	}

	@Test
	public void testDelete() {
		service.delete(20L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(14L));
	}
	@Test
	public void testQueryCount() {
		ProductQueryObject qo = new ProductQueryObject();
//		qo.setKeyWord("苹果");
		qo.setMinPrice(new BigDecimal("11110"));
		qo.setMaxPrice(new BigDecimal("11111"));
		System.out.println(dao.queryCount(qo));
	}
	@Test
	public void testQuery() {
		ProductQueryObject qo = new ProductQueryObject();
//		qo.setKeyWord("苹果");
		qo.setMinPrice(new BigDecimal("11110"));
		qo.setMaxPrice(new BigDecimal("11111"));
		dao.query(qo).forEach(System.out::println);
		
	}

}
