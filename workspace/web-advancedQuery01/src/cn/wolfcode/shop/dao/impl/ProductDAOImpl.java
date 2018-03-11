package cn.wolfcode.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.util.MyBatisUtil;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void save(Product p) {
		//获取对象
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
		session.delete("product.delete", id);
		session.commit();
	}

	@Override
	public Product get(Long id) {
		@Cleanup
		SqlSession session = MyBatisUtil.getSession();
		Product p = session.selectOne("product.get", id);
		return p;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> query(ProductQueryObject qo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long queryCount(ProductQueryObject qo) {
		// TODO Auto-generated method stub
		return null;
	}

}
