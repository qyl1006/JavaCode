package cn.wolfcode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("app对象被创建初始化");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("app对象被销毁");
		
	}

}
