package cn.wolfcode.smis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wolfcode.smis.dao.IProductDAO;
import cn.wolfcode.smis.domain.Product;
import cn.wolfcode.smis.query.ProductQueryObject;
import cn.wolfcode.smis.util.MyBatisUtil;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	public void save(Product p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.save", p);
		session.commit();
	}

	public void update(Product p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.update", p);
		session.commit();
	}

	public void delete(Long id) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.delete", id);
		session.commit();
	}

	public Product get(Long id) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.get", id);
	}

	public Long queryCount(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.queryCount", qo);
	}

	public List<Product> query(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList("product.query", qo);
	}

}