package cn.wolfcode.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wolfcode.shop.dao.IProductDAO;
import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.util.MybatisUtil;
import lombok.Cleanup;

public class ProductDAOImpl implements IProductDAO {

	public void save(Product p) {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.update("product.save", p);
		session.commit();
	}

	public void update(Product p) {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.update("product.update", p);
		session.commit();
	}

	public void delete(Long id) {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.delete("product.delete", id);
		session.commit();
	}

	public Product get(Long id) {
		//获取SqlSeesion对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		Product p = session.selectOne("product.get", id);
		return p;
	}

	public List<Product> listAll() {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		List<Product> list = session.selectList("product.list");
		return list;
	}

	public List<Product> query(ProductQueryObject qo) {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		List<Product> list = session.selectList("product.query", qo);
		
		return list;
	}

	public Long queryCount(ProductQueryObject qo) {
		//获取SqlSession对象
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		Long count = session.selectOne("product.queryCount", qo);
		return count;
	}

}
