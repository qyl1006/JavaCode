package cn.wlfcode.shop.service.impl;

import java.util.List;

import cn.wlfcode.shop.dao.IProductDAO;
import cn.wlfcode.shop.dao.impl.ProductDAOImpl;
import cn.wlfcode.shop.domain.Product;
import cn.wlfcode.shop.query.PageResult;
import cn.wlfcode.shop.query.ProductQueryObject;
import cn.wlfcode.shop.service.IProductService;

public class ProductServiceImpl implements IProductService {
	private IProductDAO dao = new ProductDAOImpl();
	
	public void save(Product p) {
		dao.save(p);
	}

	@Override
	public void update(Product p) {
		dao.update(p);
	}

	public void delete(Long p) {
		dao.delete(20L);

	}

	@Override
	public Product get(Long p) {
		return dao.get(p);
	}

	@Override
	public PageResult query(ProductQueryObject qo) {
		Long count = dao.queryCount(qo);
		if(count == 0L){
			return PageResult.EMPTY;
		}
		
		List<Product> data = dao.query(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, data);
	}

}
