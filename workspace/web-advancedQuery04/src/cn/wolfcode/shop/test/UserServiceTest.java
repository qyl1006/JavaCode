package cn.wolfcode.shop.test;

import java.util.List;

import org.junit.Test;

import cn.wolfcode.shop.dao.IUserDAO;
import cn.wolfcode.shop.dao.impl.UserDAOImpl;
import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.query.UserQueryObject;
import cn.wolfcode.shop.service.IUserService;
import cn.wolfcode.shop.service.impl.UserServiceImpl;

public class UserServiceTest {
	private IUserService service = new UserServiceImpl();
	private IUserDAO dao = new UserDAOImpl();
	
	@Test
	public void testSave() {
		User u = new User(null, "测试师姐", 17);
		service.save(u);
	}

	@Test
	public void testUpdate() {
		User u = new User(16L, "更新师姐", 18);
		service.update(u);
		
	}

	@Test
	public void testDelete() {
		service.delete(15L);
	}

	@Test
	public void testGet() {
		User user = service.get(13L);
		System.out.println(user);
	}
	
	@Test
	public void testQueryCount() {
		UserQueryObject qo = new UserQueryObject();
		qo.setName("师姐真大");
		Long count = dao.queryCount(qo);
		System.out.println(count);
	}
	
	
	@Test
	public void testQuery() {
		UserQueryObject qo = new UserQueryObject();
		qo.setName("师姐");
		List<User> data = dao.query(qo);
		data.forEach(System.out::println);
		
	}

}
