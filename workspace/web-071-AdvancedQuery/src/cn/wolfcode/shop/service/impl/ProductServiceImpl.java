package cn.wolfcode.shop.service.impl;

import java.util.List;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProductDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.service.IProductService;

public  class ProductServiceImpl implements IProductService {
	private IProductDAO dao = new ProductDAOImpl();
	
	
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

	
	public List<Product> listAll() {
		return dao.listAll();
	}

	public List<Product> query(ProductQueryObject qo) {
		return dao.query(qo);
	}

	@Override
	public Long queryCount(ProductQueryObject qo) {
		return dao.queryCount(qo);
	}

	public PageResult queryPageResult(ProductQueryObject qo) {
		PageResult result = new PageResult(qo.getCurrentPage(), qo.getPageSize(), dao.query(qo), dao.queryCount(qo));
		return result;
	}

}
