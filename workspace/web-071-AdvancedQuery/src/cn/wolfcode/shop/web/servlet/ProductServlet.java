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
	
	private IProductService servlce;
	
	public void init() throws ServletException {
		servlce = new ProductServiceImpl();
	}
	
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
	
	//query--list
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ProductQueryObject qo = createQo(req);
		PageResult result = servlce.queryPageResult(qo);
		
		req.setAttribute("qo", qo);
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
	
	//删除
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		servlce.delete(Long.valueOf(req.getParameter("id")));
		
		resp.sendRedirect("/product");
		
	}
	
	//编辑
	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String sid = req.getParameter("id");
		if(StringUtil.hasLength(sid)){
			Product p = servlce.get(Long.valueOf(sid));
			req.setAttribute("p", p);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}
	
	//增加或更新
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String sid = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		
		Product p = new Product();
		if(StringUtil.hasLength(productName)){
			productName = productName.trim();
			p.setUproductName(productName);
		}
		p.setUdir_id(Long.valueOf(dir_id));
		p.setUsupplier(supplier);
		
		if(StringUtil.hasLength(brand)){
			brand = brand.trim();
			p.setUbrand(brand);
		}
		
		if(StringUtil.hasLength(salePrice)){
			p.setUsalePrice(new BigDecimal(salePrice));
		}
		if(StringUtil.hasLength(cutoff)){
			p.setUcutoff(new BigDecimal(cutoff));
		}
		if(StringUtil.hasLength(costPrice)){
			p.setUcostPrice(new BigDecimal(costPrice));
		}
		
		if(StringUtil.hasLength(sid)){
			p.setUid(Long.valueOf(sid));
			servlce.update(p);
		}else{
			servlce.save(p);
		}
		
		resp.sendRedirect("/product");
	}
	
	//处理查询请求---封装ProductQueryObject查询对象
	private ProductQueryObject createQo(HttpServletRequest req) {
		ProductQueryObject qo = new ProductQueryObject();
	
		String productName = req.getParameter("productName");
		String minSalePrice = req.getParameter("minSalePrice");
		String maxSalePrice = req.getParameter("maxSalePrice");
		String brand = req.getParameter("brand");
		String dir_id = req.getParameter("dir_id");
		
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		
		if(StringUtil.hasLength(productName)){
			qo.setProductName(productName.trim());
		}
		if(StringUtil.hasLength(minSalePrice)){
			qo.setMinSalePrice(new BigDecimal(minSalePrice));
		}
		if(StringUtil.hasLength(maxSalePrice)){
			qo.setMaxSalePrice(new BigDecimal(maxSalePrice));
		}
		if(StringUtil.hasLength(brand)){
			qo.setBrand(brand.trim());
		}
		if(StringUtil.hasLength(dir_id)){
			qo.setDir_id(Long.valueOf(dir_id));
		}
		if(StringUtil.hasLength(currentPage)){
			qo.setCurrentPage(Integer.parseInt(currentPage));
		}
		if(StringUtil.hasLength(pageSize)){
			qo.setPageSize(Integer.parseInt(pageSize));
		}
		
		return qo;
	}
}
