package cn.wolfcode.shop.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProduDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.service.IProduService;
import cn.wolfcode.shop.service.impl.ProduServiceImpl;

public class ProduServiceTest {
	private IProductDAO dao = new ProduDAOImpl();
	private IProduService service = new ProduServiceImpl();
	
	@Test
	public void testSave() {
		Product p = new Product(null, "测试保存", new BigDecimal("11110"), "test");
		service.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product(8L, "测试更新", new BigDecimal("11110"), "test");
		service.update(p);
	}

	@Test
	public void testDelete() {
		service.delete(8L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(1L));
	}
	
	@Test
	public void testQueryCount() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setMinPrice(new BigDecimal("1800"));
		qo.setMaxPrice(new BigDecimal("6000"));
		Long count = dao.queryCount(qo);
		System.out.println(count);
	}
	@Test
	public void testQuery() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setMinPrice(new BigDecimal("1800"));
		qo.setMaxPrice(new BigDecimal("6000"));
		List<Product> data = dao.query(qo);
		data.forEach(System.out::println);
	}

}
