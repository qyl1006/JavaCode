package cn.colfcode.shop.service;

import cn.colfcode.shop.domain.Product;
import cn.colfcode.shop.query.PageResult;
import cn.colfcode.shop.query.ProductQueryObject;

public interface IProductService {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	PageResult query(ProductQueryObject qo);
}
