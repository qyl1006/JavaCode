package cn.wolfcode.shop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object obj = req.getSession().getAttribute("USER_IN_SESSION");
		if(obj == null){
			req.setAttribute("msg2", "请登陆");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		chain.doFilter(req, resp);//已经登陆,放行
	}

	public void destroy() {}

}
