package cn.wolfcode.shop.service.impl;

import java.util.List;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProduDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.service.IProduService;

public class ProduServiceImpl implements IProduService {

	private IProductDAO dao = new ProduDAOImpl();
	
	public void save(Product p) {
		dao.save(p);
	}

	public void update(Product p) {
		dao.update(p);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Product get(Long id) {
		return dao.get(id);
	}

	public PageResult query(ProductQueryObject qo) {
		Long count = dao.queryCount(qo);
		if(count == 0L){
			return PageResult.EMPYT_PAGE;
		}
		List<Product> data = dao.query(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, data);
	}

}
