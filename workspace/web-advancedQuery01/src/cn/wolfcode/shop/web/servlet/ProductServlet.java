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
import cn.wolfcode.shop.query.ProductQueryObject;
import cn.wolfcode.shop.service.IProductService;
import cn.wolfcode.shop.service.impl.ProductServiceImpl;
import cn.wolfcode.shop.util.StringUtil;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IProductService service = new ProductServiceImpl();
	
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
		ProductQueryObject qo = creatQo(req);
		
		PageResult result = service.query(qo);
		req.setAttribute("qo", qo);
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
	
	//接收用户请求的参数,,封装成对象
	private ProductQueryObject creatQo(HttpServletRequest req) {
		ProductQueryObject qo = new ProductQueryObject();
		
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		String productName = req.getParameter("productName");
		String minsalePrice = req.getParameter("minsalePrice");
		String maxsalePrice = req.getParameter("maxsalePrice");
		String brand = req.getParameter("brand");
		String dir_id = req.getParameter("dir_id");
		
		if(StringUtil.haslength(currentPage)){
			qo.setCurrentPage(Integer.valueOf(currentPage.trim()));
		}
		if(StringUtil.haslength(pageSize)){
			qo.setPageSize(Integer.valueOf(pageSize.trim()));
		}
		if(StringUtil.haslength(productName)){
			qo.setProductName(productName.trim());
		}
		if(StringUtil.haslength(minsalePrice)){
			qo.setMinsalePrice(new BigDecimal(minsalePrice.trim()));
		}
		if(StringUtil.haslength(maxsalePrice)){
			qo.setMaxsalePrice(new BigDecimal(maxsalePrice.trim()));
		}
		if(StringUtil.haslength(brand)){
			qo.setBrand(brand.trim());
		}
		if(StringUtil.haslength(dir_id)){
			qo.setDir_id(Long.valueOf(dir_id));
		}
		return qo;
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if(StringUtil.haslength(id)){
			service.delete(Long.valueOf(id));
		}
		resp.sendRedirect("/product");
		
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		if(StringUtil.haslength(id)){
			Product product = service.get(Long.valueOf(id));
			req.setAttribute("p", product);
		}
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);;
	}
	private void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String cosPrice = req.getParameter("cosPrice");
		
		Product p = new Product();
		if(StringUtil.haslength(productName)){
			p.setUproductName(productName);
		}
		if(StringUtil.haslength(dir_id)){
			p.setUdir_id(Long.valueOf(dir_id));;
		}
		if(StringUtil.haslength(salePrice)){
			p.setUsalePrice(new BigDecimal(salePrice));
		}
		if(StringUtil.haslength(supplier)){
			p.setUsupplier(supplier);
		}
		if(StringUtil.haslength(brand)){
			p.setUbrand(brand);
		}
		if(StringUtil.haslength(cutoff)){
			p.setUcutoff(new BigDecimal(cutoff));
		}
		if(StringUtil.haslength(cosPrice)){
			p.setUcosPrice(new BigDecimal(cosPrice));
		}
		
		if(StringUtil.haslength(id)){
			p.setUid(Long.valueOf(id));
			service.update(p);
		}else{
			service.save(p);
		}
		
		resp.sendRedirect("/product");
	}
	
	
}
