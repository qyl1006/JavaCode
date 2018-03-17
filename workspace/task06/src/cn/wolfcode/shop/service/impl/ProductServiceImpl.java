package cn.wolfcode.shop.service.impl;

import java.util.List;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProductDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.QueryObject;
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

	@Override
	public void delete(Long p) {
		dao.delete(p);
	}

	@Override
	public Product get(Long p) {
		return dao.get(p);
	}

	@Override
	public PageResult query(QueryObject qo) {
		Long count = dao.queryCount(qo);
		if(count == 0L){
			return PageResult.EMPTY;
		}
		
		List<Product> data = dao.query(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, data);
	}

}
