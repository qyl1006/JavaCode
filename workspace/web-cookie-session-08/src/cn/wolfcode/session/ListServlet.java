package cn.wolfcode.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/list")
public class ListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		
		//获取"记住我"的name的value值
		String re = req.getParameter("re");
//		
//		if("on".equals(re)){
//			Cookie c = new Cookie("username", username);
//			c.setMaxAge(Integer.MAX_VALUE);
//			resp.addCookie(c);
//		}else{
//			Cookie c = new Cookie("username", "");
//			c.setMaxAge(0);
//			resp.addCookie(c);
//		}
		
//		Cookie c = new Cookie("username", username);
//		resp.addCookie(c);
		
		//获取对象-->有就返回,没有就创建
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/session/list.jsp").forward(req, resp);
	}
}
