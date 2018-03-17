package cn.wolfcode.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.QueryObject;
import cn.wolfcode.shop.util.MyBatisUtil;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	@Override
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
	public void delete(Long p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		session.update("product.delete", p);
		session.commit();
	}

	@Override
	public Product get(Long p) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.get", p);
	}

	@Override
	public Long queryCount(QueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne("product.queryCount", qo);
	}

	@Override
	public List<Product> query(QueryObject qo) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList("product.query", qo);
	}

}
