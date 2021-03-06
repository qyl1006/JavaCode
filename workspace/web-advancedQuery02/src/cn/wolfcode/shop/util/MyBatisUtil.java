package cn.wolfcode.shop.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	static{
		try {
			InputStream out = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		return factory.openSession();
	}
}
