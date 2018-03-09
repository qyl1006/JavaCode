package cn.wolfcode.shop.service;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProductQueryObject;

public interface IProductService {
	void save(Product p);
	
	void update(Product p);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> listAll();
	
	PageResult queryPageResult(ProductQueryObject qo);
	
	List<Product> query(ProductQueryObject qo);
	Long queryCount(ProductQueryObject qo);
}
