package com.movie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
	//该方法在响应页面之后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 System.out.println("afterHandle");   

	}
	//该方法在执行控制器的方法之后，响应页面之前执行；（可以处理视图）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("postHandler");

	}

	//该方法在执行控制器方法之前执行，
    //如果当前方法返回值为false，表示不能执行到控制器方法，代码只能执行到该方法结束
    //如果返回值是true，表示执行到控制器方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler");
		Object user=request.getSession().getAttribute("user");
		if (user!=null) {
			return true;
		}else {
			request.getRequestDispatcher("/WEB-INF/jsp/UserLogin.jsp").forward(request, response);
			return false;
		}
		
	}

}
