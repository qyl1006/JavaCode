package cn.wolfcode.shop.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
	private static SqlSessionFactory fac;
	
	static{
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			fac = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		return fac.openSession();
	}
}
