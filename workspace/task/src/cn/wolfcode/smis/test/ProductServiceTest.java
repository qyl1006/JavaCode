package cn.wolfcode.smis.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import cn.wolfcode.smis.dao.IProductDAO;
import cn.wolfcode.smis.dao.impl.ProductDAOImpl;
import cn.wolfcode.smis.domain.Product;
import cn.wolfcode.smis.query.ProductQueryObject;
import cn.wolfcode.smis.service.IProductService;
import cn.wolfcode.smis.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	private IProductService service = new ProductServiceImpl();
	private IProductDAO dao = new ProductDAOImpl();
		
	@Test
	public void testSave() {
		Product p = new Product(null, "测试保存", new BigDecimal("11"), "123");
		service.save(p);
	}

	@Test
	public void testUpdate() {
		Product p = new Product(5L, "测试更新", new BigDecimal("11"), "123");
		service.update(p);
	}

	@Test
	public void testDelete() {
		service.delete(5L);
	}

	@Test
	public void testGet() {
		System.out.println(service.get(4L));
	}
	@Test
	public void testQueryCount() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setMinprice(new BigDecimal("30"));
		qo.setMaxprice(new BigDecimal("1800"));
		Long count = dao.queryCount(qo);
		System.out.println(count);
	}
	@Test
	public void testQuery() {
		ProductQueryObject qo = new ProductQueryObject();
		qo.setMinprice(new BigDecimal("30"));
		qo.setMaxprice(new BigDecimal("1800"));
		List<Product> p = dao.query(qo);
		p.forEach(System.out::println);
		
	}

}