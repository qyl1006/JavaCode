package cn.wlfcode.shop.dao;

import java.util.List;

import cn.wlfcode.shop.domain.Product;
import cn.wlfcode.shop.query.ProductQueryObject;

public interface IProductDAO {
	void save(Product p);
	void update(Product p);
	void delete(Long p);
	Product get(Long p);
	
	Long queryCount(ProductQueryObject qo);
	List<Product> query(ProductQueryObject qo);
}
