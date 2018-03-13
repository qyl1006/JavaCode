package cn.wolfcode.smis.service.impl;

import java.util.List;

import cn.wolfcode.smis.dao.IUserDAO;
import cn.wolfcode.smis.dao.impl.UserDAOImpl;
import cn.wolfcode.smis.domain.User;
import cn.wolfcode.smis.query.PageResult;
import cn.wolfcode.smis.query.UserQueryObject;
import cn.wolfcode.smis.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao = new UserDAOImpl();

	public void save(User u) {
		dao.save(u);
	}

	public void update(User u) {
		dao.update(u);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public User get(Long id) {
		return dao.get(id);
	}

	public PageResult query(UserQueryObject qo) {
		Long count = dao.queryCount(qo);
		if(count == 0){
			return PageResult.EMPTY_PAGE;
		}
		List<User> data = dao.query(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, data);
	}

}
