package cn.wolfcode.shop.test;

import org.junit.Test;

import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.UserQueryObject;
import cn.wolfcode.shop.service.IUserService;
import cn.wolfcode.shop.service.impl.UserServiceImpl;

public class UserServiceTest {
	private IUserService service = new UserServiceImpl();
	
	@Test
	public void testSave() {
		User u = new User(null, "测试保存", 18);
		service.save(u);
	}

	@Test
	public void testUpdate() {
		User u = new User(7L, "测试更新", 111);
		service.update(u);
	}

	@Test
	public void testDelete() {
		service.delete(7L);
	}

	@Test
	public void testQuery() {
		//测试PageResult
		UserQueryObject qo = new UserQueryObject();
		qo.setName("测试");
		PageResult result = service.query(qo);
		result.getData().forEach(System.out::println);
		System.out.println(result.getPageCount());
	}

	@Test
	public void testQueryCount() {
		User user = service.get(1l);
		System.out.println(user);
	}

}
