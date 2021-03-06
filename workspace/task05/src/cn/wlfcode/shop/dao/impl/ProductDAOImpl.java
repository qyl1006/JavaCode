package cn.wlfcode.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wlfcode.shop.dao.IProductDAO;
import cn.wlfcode.shop.domain.Product;
import cn.wlfcode.shop.query.ProductQueryObject;
import cn.wlfcode.shop.util.MyBatis;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void save(Product p) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		session.update("product.save", p);
		session.commit();
	}

	@Override
	public void update(Product p) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		session.update("product.update", p);
		session.commit();

	}

	@Override
	public void delete(Long p) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		session.update("product.delete", p);
		session.commit();

	}

	@Override
	public Product get(Long p) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		return session.selectOne("product.get", p);
	}

	@Override
	public Long queryCount(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		return session.selectOne("product.queryCount", qo);
	}

	@Override
	public List<Product> query(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatis.getSession();
		return session.selectList("product.query", qo);
	}

}
