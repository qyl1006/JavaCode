package cn.wolfcode.shop.dao;

import java.util.List;

import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.query.UserQueryObject;

public interface IUserDAO {
	void save(User u);
	void update(User u);
	void delete(Long id);
	User get(Long id);
	
	List<User> query(UserQueryObject qo);
	Long queryCount(UserQueryObject qo);
	User login(User u);
}
