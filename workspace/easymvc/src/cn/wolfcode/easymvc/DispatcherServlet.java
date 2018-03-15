package cn.wolfcode.easymvc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePackageName; //去哪个包中找分支控制器
	private Map<String, Object> controllerBean = new HashMap<>();
	private Map<String, Method> urlBean = new HashMap<>();
	
	public void init() throws ServletException {
		try {
			basePackageName = getInitParameter("basePackageName");
			//扫描当前项目中有哪些Controller,根据注解来识别
			ClassScanner cs = new ClassScanner(basePackageName);
			List<Class<?>> classes = cs.getClassWithAnnotation(Controller.class);
			for (Class<?> clz : classes) {
				Object obj = clz.newInstance();
				controllerBean.put(clz.getName(), obj);
				//看下当前类中哪些方法有@RequestMapping注解
				Method[] ms = clz.getDeclaredMethods();
				for (Method m : ms) {
					RequestMapping anno = m.getAnnotation(RequestMapping.class);
					if (anno != null) { //该方法贴切有RequestMapping注解
						urlBean.put(anno.value(), m);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//识别当前被访问的资源  localhost/hello.do
		String uri = req.getRequestURI();
		uri = uri.substring(1,uri.lastIndexOf('.'));
		Method m = urlBean.get(uri);
		if (m == null) { //没有这个资源
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Object obj = controllerBean.get(m.getDeclaringClass().getName());
		try {
			//1:接收请求参数,封装成对象
			//2:调用业务方法处理请求
			ModelAndView mv = (ModelAndView) m.invoke(obj);
			//3:控制界面跳转
			//拿到需要共享的数据
			for (Entry<String, Object> entry :mv.getMap().entrySet()) {
				req.setAttribute(entry.getKey(), entry.getValue());
			}
			//拿到跳转视图的名称
			String viewName = mv.getViewName();
			req.getRequestDispatcher(viewName).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
