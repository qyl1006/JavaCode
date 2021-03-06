package cn.wolfcode.shop.service;

import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.UserQueryObject;

public interface IUserService {
	void save(User u);
	void update(User u);
	void delete(Long id);
	User get(Long id);
	
	PageResult query(UserQueryObject qo);
}
