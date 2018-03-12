package cn.wolfcode.shop.service.impl;

import java.util.List;

import cn.wolfcode.shop.dao.impl.IProductDAO;
import cn.wolfcode.shop.dao.impl.ProductDAOImpl;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;
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
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Product get(Long id) {
		return dao.get(id);
	}

	public List<Product> list() {
		return dao.list();
	}

	@Override
	public PageResult query(ProductQueryObject qo) {
		Long count = dao.queryCount(qo);
		if(count == 0){
			return PageResult.EMTPY_PAGE;
		}
		List<Product> list = dao.query(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
	}

	@Override
	public Long queryCount(ProductQueryObject qo) {
		System.out.println(PageResult.EMTPY_PAGE);
		return dao.queryCount(qo);
	}

}
