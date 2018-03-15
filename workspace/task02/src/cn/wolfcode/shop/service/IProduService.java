package cn.wolfcode.shop.service;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;

public interface IProduService {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	PageResult query(ProductQueryObject qo);
}
