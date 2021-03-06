package cn.wolfcode.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session/get")
public class GetServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
//		String username = req.getParameter("username");
//		String re = req.getParameter("re");
////		
////		if("on".equals(re)){
////			Cookie c = new Cookie("username", username);
////			c.setMaxAge(Integer.MAX_VALUE);
////			resp.addCookie(c);
////		}else{
////			Cookie c = new Cookie("username", "");
////			c.setMaxAge(0);
////			resp.addCookie(c);
////		}
//		
//		Cookie c = new Cookie("username", username);
//		resp.addCookie(c);
		
		req.getSession().setMaxInactiveInterval(10);
		
		req.getRequestDispatcher("/WEB-INF/views/session/get.jsp").forward(req, resp);
	}
}
