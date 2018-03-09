package cn.wolfcode.shop.dao;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProductQueryObject;

public interface IProductDAO {
	void save(Product p);
	
	void update(Product p);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> listAll();
	
	List<Product> query(ProductQueryObject qo);
	
	Long queryCount(ProductQueryObject qo);
}
