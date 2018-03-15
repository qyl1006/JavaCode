package cn.wolfcode.smis.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	static{
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		return factory.openSession();
	}
}
