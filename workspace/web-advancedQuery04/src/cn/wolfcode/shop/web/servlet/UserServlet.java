package cn.wolfcode.shop.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wolfcode.shop.domain.User;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.UserQueryObject;
import cn.wolfcode.shop.service.IUserService;
import cn.wolfcode.shop.service.impl.UserServiceImpl;
import cn.wolfcode.shop.util.StringUtil;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserService service = new UserServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String cmd = req.getParameter("cmd");
		if("delete".equals(cmd)){
			delete(req, resp);
		}else if("edit".equals(cmd)){
			edit(req, resp);
		}else if("saveOrUpdate".equals(cmd)){
			saveOrUpdate(req, resp);
		}else{
			list(req, resp);
		}
	}
	
	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserQueryObject qo = creatQo(req);
		PageResult result = service.query(qo);
		req.setAttribute("qo", qo);
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(req, resp);
	}
	
	private UserQueryObject creatQo(HttpServletRequest req) {
		UserQueryObject qo = new UserQueryObject();
		
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		String name = req.getParameter("name");
		
		if(StringUtil.haslength(currentPage)){
			qo.setCurrentPage(Integer.valueOf(currentPage.trim()));
		}
		if(StringUtil.haslength(pageSize)){
			qo.setPageSize(Integer.valueOf(pageSize.trim()));
		}
		if(StringUtil.haslength(name)){
			qo.setName(name.trim());
		}
		
		return qo;
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	private void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(StringUtil.haslength(id)){
			User user = service.get(Long.valueOf(id.trim()));
			req.setAttribute("u", user);
		}
		req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
		
	}
	
	private void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		User u = new User(null, name.trim(), Integer.valueOf(age.trim()));
		
		if(StringUtil.haslength(id)){
			u.setId(Long.valueOf(id.trim()));
			service.update(u);
		}else{
			service.save(u);
		}
		
		resp.sendRedirect("/user");
	}
}
