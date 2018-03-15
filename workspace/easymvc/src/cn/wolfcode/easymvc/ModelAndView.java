package cn.wolfcode.easymvc;

import java.util.HashMap;
import java.util.Map;

// 封装数据模型对象和逻辑视图名称
public class ModelAndView {
	private Map<String, Object> map = new HashMap<>();
	private String viewName;
	
	//保存需要共享的数据
	public void addAttribute(String name, Object value) {
		map.put(name, value);
	}

	//保存逻辑视图名称
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public String getViewName() {
		return viewName;
	}
}
