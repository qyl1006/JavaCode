package cn.wolfcode.smis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wolfcode.smis.dao.IUserDAO;
import cn.wolfcode.smis.domain.User;
import cn.wolfcode.smis.query.PageResult;
import cn.wolfcode.smis.query.UserQueryObject;
import cn.wolfcode.smis.util.MybatisUtil;
import lombok.Cleanup;

public class UserDAOImpl implements IUserDAO {

	public void save(User u) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.update("user.save", u);
		session.commit();
	}

	public void update(User u) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.update("user.update", u);
		session.commit();
	}

	public void delete(Long id) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		session.delete("user.delete", id);
		session.commit();
	}

	public User get(Long id) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("user.get", id);
		
	}

	public List<User> query(UserQueryObject qo) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		return session.selectList("user.query", qo);
	}

	public Long queryCount(UserQueryObject qo) {
		@Cleanup
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("user.queryCount", qo);
	}

}
