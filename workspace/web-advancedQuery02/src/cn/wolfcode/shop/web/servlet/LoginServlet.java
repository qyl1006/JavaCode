package cn.wolfcode.shop.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.service.IUserService;
import cn.wolfcode.shop.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IUserService service = new UserServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收请求参数.封装成对象
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		User u = new User(null, name, Integer.valueOf(age));
		//调用业务方法,处理一些业务逻辑
		User user = service.login(u);
		if(user == null){
			req.setAttribute("msg", "您的大名或年龄输入错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		//控制页面跳转
		req.getSession().setAttribute("USER_IN_SESSION", user);
		resp.sendRedirect("/user");
	}
}
