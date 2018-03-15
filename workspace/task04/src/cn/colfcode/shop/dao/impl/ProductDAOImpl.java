package cn.colfcode.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.colfcode.shop.dao.IProductDAO;
import cn.colfcode.shop.domain.Product;
import cn.colfcode.shop.query.ProductQueryObject;
import cn.colfcode.shop.util.MyBatisUtil;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	public void save(Product p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.save", p);
		session.commit();
	}

	@Override
	public void update(Product p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.update", p);
		session.commit();

	}

	@Override
	public void delete(Long id) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.delete", id);
		session.commit();

	}

	@Override
	public Product get(Long id) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.get", id);
	}

	@Override
	public Long queryCount(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.queryCount", qo);
	}

	@Override
	public List<Product> query(ProductQueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList("product.query", qo);
	}

}