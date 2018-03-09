package cn.wolfcode.shop.dao;

import java.util.List;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProductQueryObject;
/**
 * 用于直接操作数据库CRUD的DAO接口
 * @author Qyuelin
 *
 */
public interface IProductDAO {
	/**
	 * 保存一个对象
	 * @param p 被保存的对象
	 */
	void save(Product p);
	
	/**
	 * 更新一个对象
	 * @param p 被更新的对象,该对象必须有一个对象
	 */
	void update(Product p);
	
	/**
	 * 删除一个对象
	 * @param id 被删除对象的ID
	 */
	void delete(Long id);
	
	/**
	 * 查询一个对象信息
	 * @param id 被查询对象的ID
	 * @return 返回一个对象信息,若查询不到,则返回null
	 */
	Product get(Long id);
	
	/**
	 * 查询表中所有信息
	 * @return 返回所有信息的List集合,若表中无数据,则返回空集合
	 */
	List<Product> listAll();
	
	/**
	 * 多条件查询数据库
	 * @param qo 用户输入条件信息封装的对象
	 * @return 返回一个List集合
	 */
	List<Product> query(ProductQueryObject qo);
	
	/**
	 * 查询多条件下总记录数
	 * @param qo 用户输入的条件信息封装的对象
	 * @return
	 */
	Long queryCount(ProductQueryObject qo);
}
