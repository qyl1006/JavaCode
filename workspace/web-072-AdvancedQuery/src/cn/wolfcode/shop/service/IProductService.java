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
	
	List<Product> query(ProductQueryObject qo);
	
	/**
	 * 多条件下的查询方法
	 * @param qo 用于输入的条件信息封装的对象
	 * @return 返回一个多条件下查询回来的结果对象
	 */
	PageResult advancedQuery(ProductQueryObject qo);

}
