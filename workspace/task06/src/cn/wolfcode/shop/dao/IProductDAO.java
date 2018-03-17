package cn.wolfcode.shop.dao;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.QueryObject;

public interface IProductDAO {
	void save(Product p);
	void update(Product p);
	void delete(Long p);
	Product get(Long p);
	
	Long queryCount(QueryObject qo);
	List<Product> query(QueryObject qo);
}
