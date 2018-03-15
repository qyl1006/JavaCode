package cn.wolfcode.smis.service;

import cn.wolfcode.smis.domain.Product;
import cn.wolfcode.smis.query.PageResult;
import cn.wolfcode.smis.query.ProductQueryObject;

public interface IProductService {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	PageResult query(ProductQueryObject qo);
}
