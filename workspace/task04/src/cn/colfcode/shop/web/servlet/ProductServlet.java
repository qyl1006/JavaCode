package cn.colfcode.shop.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.colfcode.shop.domain.Product;
import cn.colfcode.shop.query.PageResult;
import cn.colfcode.shop.query.ProductQueryObject;
import cn.colfcode.shop.service.IProductService;
import cn.colfcode.shop.service.impl.ProductServiceImpl;
import cn.colfcode.shop.util.StringUtil;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IProductService service = new ProductServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String cmd = req.getParameter("cmd");
		
		if("edit".equals(cmd)){
			edit(req, resp);
		}else if("delete".equals(cmd)){
			delete(req, resp);
		}else if("saveOrUpdate".equals(cmd)){
			saveOrUpdate(req, resp);
		}else{
			list(req, resp);
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductQueryObject qo = creatQo(req);
		PageResult result = service.query(qo);
		
		req.setAttribute("qo", qo);
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
		
	}
	private ProductQueryObject creatQo(HttpServletRequest req) {
		ProductQueryObject qo = new ProductQueryObject();
		
		String keyWord = req.getParameter("keyWord");
		String currentPage  = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		String  minPrice = req.getParameter("minPrice");
		String  maxPrice = req.getParameter("maxPrice");
		
		if(StringUtil.hasLength(keyWord)){
			qo.setKeyWord(keyWord);
		}
		if(StringUtil.hasLength(currentPage)){
			qo.setCurrentPage(Integer.valueOf(currentPage));
		}
		if(StringUtil.hasLength(pageSize)){
			qo.setPageSize(Integer.valueOf(pageSize));
		}
		if(StringUtil.hasLength(minPrice)){
			qo.setMinPrice(new BigDecimal(minPrice));
		}
		if(StringUtil.hasLength(maxPrice)){
			qo.setMaxPrice(new BigDecimal(maxPrice));
		}
		return qo;
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		service.delete(Long.valueOf(req.getParameter("id")));
		
		resp.sendRedirect("/product");
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if(StringUtil.hasLength(id)){
			Product p = service.get(Long.valueOf(id));
			req.setAttribute("p", p);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
		
		
	}
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String info = req.getParameter("info");
		
		
		Product p = new Product(null, name, new BigDecimal(price), info);
		if(StringUtil.hasLength(id)){
			p.setId(Long.valueOf(id));
			service.update(p);
		}else{
			service.save(p);
		}
		
		resp.sendRedirect("/product");
	}
}

