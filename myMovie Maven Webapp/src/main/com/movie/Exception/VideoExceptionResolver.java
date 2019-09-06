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
		//�������쳣����
		VideoException videoException=null;
		//�Զ�����쳣����ȡ���쳣��Ϣ�ڴ�������ʾ
		if (e instanceof VideoException) {
			videoException=(VideoException)e;
		}else {
			//���Զ�����쳣���ԡ�δ֪������ʾ
			videoException=new VideoException("δ֪����");
		}
		//������Ϣ
		String message=videoException.getMessage();
		//��������Ϣ����ҳ��
		mv.addObject("message",message);
		//ָ�����ҳ��
		mv.setViewName("error");
		return mv;
	}

}
