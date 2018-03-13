package cn.wolfcode.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter2 implements javax.servlet.Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("拦截器初始化Demo2");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("请求过滤/拦截Demo2");
		
		chain.doFilter(request, response);
		System.out.println("响应放行Demo2");
	}

	public void destroy(){}		
}
