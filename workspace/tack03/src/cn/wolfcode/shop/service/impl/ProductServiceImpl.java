package cn.wolfcode.shop.service.impl;

import java.util.List;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProductDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProduQueryObject;
import cn.wolfcode.shop.service.IProductService;

public class ProductServiceImpl implements IProductService {
	private IProductDAO dao = new ProductDAOImpl(); 
	
	@Override
	public void save(Product p) {
		dao.save(p);
	}

	@Override
	public void update(Product p) {
		dao.update(p);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Product get(Long id) {
		return dao.get(id);
	}

	@Override
	public PageResult query(ProduQueryObject qo) {
		Long count = dao.queryCount(qo);
		System.out.println(count);
		if(count == 0L){
			return PageResult.EMPTY_PAGE;
		}
		List<Product> data = dao.query(qo);
		data.forEach(System.out::println);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, data);
	}

}
