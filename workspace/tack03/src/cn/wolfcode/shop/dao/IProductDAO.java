package cn.wolfcode.shop.dao;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProduQueryObject;

public interface IProductDAO {
	void save(Product p);
	void update(Product p);
	void delete(Long id);
	Product get(Long id);
	
	Long queryCount(ProduQueryObject qo);
	List<Product> query(ProduQueryObject qo);
}
