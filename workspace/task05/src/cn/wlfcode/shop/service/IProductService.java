package cn.wlfcode.shop.service;

import cn.wlfcode.shop.domain.Product;
import cn.wlfcode.shop.query.PageResult;
import cn.wlfcode.shop.query.ProductQueryObject;

public interface IProductService {
	void save(Product p);
	void update(Product p);
	void delete(Long p);
	Product get(Long p);
	
	PageResult query(ProductQueryObject qo);
}
