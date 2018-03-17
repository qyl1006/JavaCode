package cn.wolfcode.shop.service;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.QueryObject;

public interface IProductService {
	void save(Product p);
	void update(Product p);
	void delete(Long p);
	Product get(Long p);
	
	PageResult query(QueryObject qo);
}
