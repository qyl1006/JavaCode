package cn.wolfcode.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class Cookie_Session extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String re = req.getParameter("re");
//		Object value = req.getSession().getAttribute(username);
//		
//		if(value == null){
//			resp.sendRedirect("/login.jsp");
//			return;
//		}
		
		if(!("admin".equals(username))){
			System.out.println("登陆失败");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		System.out.println("登陆成功,查看资源..");
		
		req.getSession().setAttribute("username", username);
		
		
		if("on".equals(re)){
			Cookie c = new Cookie("username", username);
			c.setMaxAge(Integer.MAX_VALUE);
			resp.addCookie(c);
		}else{
			Cookie c = new Cookie("username", "");
			c.setMaxAge(0);
			resp.addCookie(c);
		}
	}
	
}
