package com.movie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//��¼������
public class LoginInterceptor implements HandlerInterceptor {
	//�÷�������Ӧҳ��֮��ִ��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 System.out.println("afterHandle");   

	}
	//�÷�����ִ�п������ķ���֮����Ӧҳ��֮ǰִ�У������Դ�����ͼ��
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("postHandler");

	}

	//�÷�����ִ�п���������֮ǰִ�У�
    //�����ǰ��������ֵΪfalse����ʾ����ִ�е�����������������ֻ��ִ�е��÷�������
    //�������ֵ��true����ʾִ�е�����������
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
