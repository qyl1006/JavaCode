package cn.wolfcode.shop.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wolfcode.shop.domain.Product;
import cn.wolfcode.shop.query.PageResult;
import cn.wolfcode.shop.query.ProduQueryObject;
import cn.wolfcode.shop.service.IProductService;
import cn.wolfcode.shop.service.impl.ProductServiceImpl;
import cn.wolfcode.shop.util.StringUtil;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IProductService service = new ProductServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String cmd =req.getParameter("cmd");
		if("saveOrUpdate".equals(cmd)){
			saveOrUpdate(req, resp);
		}else if("edit".equals(cmd)){
			edit(req, resp);
		}else if("delete".equals(cmd)){
			delete(req, resp);
		}else{
			list(req, resp);
		}
		
	}
	
	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ProduQueryObject qo = creatQo(req);
		PageResult result = service.query(qo);

		req.setAttribute("qo", qo);
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
	
	private ProduQueryObject creatQo(HttpServletRequest req) {
		ProduQueryObject qo = new ProduQueryObject();
		
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		String keyWord = req.getParameter("keyWord");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		
		if(StringUtil.hasLength(currentPage)){
			qo.setCurrentPage(Integer.valueOf(currentPage.trim()));
		}
		if(StringUtil.hasLength(pageSize)){
			qo.setPageSize(Integer.valueOf(pageSize.trim()));
		}
		if(StringUtil.hasLength(keyWord)){
			qo.setKeyWord(keyWord.trim());
		}
		if(StringUtil.hasLength(minPrice)){
			qo.setMinPrice(new BigDecimal(minPrice.trim()));
		}
		if(StringUtil.hasLength(maxPrice)){
			qo.setMaxPrice(new BigDecimal(maxPrice.trim()));
		}
		
		return qo;
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(StringUtil.hasLength(id)){
			service.delete(Long.valueOf(id));
		}
		
		resp.sendRedirect("/product");
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(StringUtil.hasLength(id)){
			Product p = service.get(Long.valueOf(id.trim()));
			req.setAttribute("p", p);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
		
	}
	private void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
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
