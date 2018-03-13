package cn.wolfcode.smis.service;

import cn.wolfcode.smis.domain.User;
import cn.wolfcode.smis.query.PageResult;
import cn.wolfcode.smis.query.UserQueryObject;

public interface IUserService {
	void save(User u);
	void update(User u);
	void delete(Long id);
	User get(Long id);
	
	PageResult query(UserQueryObject qo);
}
