package cn.wolfcode.smis.dao;

import java.util.List;

import cn.wolfcode.smis.domain.Product;
import cn.wolfcode.smis.query.ProductQueryObject;

public interface IProductDAO {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	Long queryCount(ProductQueryObject qo);
	List<Product> query(ProductQueryObject qo);
}
