package com.movie.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class VideoExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o,
			Exception e) {
		ModelAndView mv=new ModelAndView();
		//解析出异常类型
		VideoException videoException=null;
		//自定义的异常都将取出异常信息在错误面显示
		if (e instanceof VideoException) {
			videoException=(VideoException)e;
		}else {
			//非自定义的异常都以”未知错误“显示
			videoException=new VideoException("未知错误！");
		}
		//错误信息
		String message=videoException.getMessage();
		//将错误信息传到页面
		mv.addObject("message",message);
		//指向错误页面
		mv.setViewName("error");
		return mv;
	}

}
