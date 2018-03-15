package cn.colfcode.shop.dao;

import java.util.List;

import cn.colfcode.shop.domain.Product;
import cn.colfcode.shop.query.ProductQueryObject;

public interface IProductDAO {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	Long queryCount(ProductQueryObject qo);
	List<Product> query(ProductQueryObject qo);
}
