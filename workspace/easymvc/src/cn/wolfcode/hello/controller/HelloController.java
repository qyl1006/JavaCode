package cn.wolfcode.hello.controller;

import cn.wolfcode.easymvc.Controller;
import cn.wolfcode.easymvc.ModelAndView;
import cn.wolfcode.easymvc.RequestMapping;

@Controller //该注解贴在哪个类上表示该类就是一个分支控制器
public class HelloController {
	// localhost/hello.do
	@RequestMapping("hello") //访问资源名称为hello的资源时,调用该方法处理
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		//在请求作用域中共享数据
		mv.addAttribute("msg", "你好,EasyMVC");
		//设置请求转发的跳转视图
		mv.setViewName("/WEB-INF/views/hello.jsp");
		return mv;
	}
	
	public ModelAndView hello1() {
		ModelAndView mv = new ModelAndView();
		//在请求作用域中共享数据
		mv.addAttribute("msg", "你好,EasyMVC");
		//设置请求转发的跳转视图
		mv.setViewName("/WEB-INF/views/hello.jsp");
		return mv;
	}
}
