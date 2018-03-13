package cn.wolfcode.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements javax.servlet.Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("拦截器初始化Demo1");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("请求过滤/拦截Demo1");
		
		chain.doFilter(request, response);
		System.out.println("响应放行Demo1");
	}

	public void destroy(){}		
}
