package com.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.Exception.VideoException;
import com.movie.pojo.News;

import com.movie.service.NewsSearch;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;


import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/NewsControl")
public class NewsControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(NewsControl.class);
	
	@Autowired
	private NewsSearch newsSearch;
	/**
	 * ��ȡ���ż���չʾ������ҳ��
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/news.do")
	public String getNewsList(Model model) throws Exception{
		List<News> newsList=null;
		
		newsList=newsSearch.getNewsList();		
		if (newsList==null) {
			throw new VideoException("����������Ϣ��");
			
		}
		for (News news : newsList) {
			System.out.println("���ű����ǣ�"+news.getNews_Title());
		}
		model.addAttribute("newsList", newsList);
		return "news";
	}
	/**
	 * ����Ա��ҳ��ȡ���ŵ�����ҳ��
	 * @param pageNow
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/newsManage.do")
	public String getNewsWithAdmin(@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{
		LimitPageList newsAdminPageList=null;
    	Page page=null;
    	//��ҳ��ȡ���ŵ�����ҳ��
    	newsAdminPageList=newsSearch.selectNewsWithAdmin(pageNow);
    	//��ȡҳ����Ϣ
    	page=newsAdminPageList.getPage();
    	//ǿ������ת��    	
		@SuppressWarnings("unchecked")
		List<News> newsAdminList=(List<News>) newsAdminPageList.getList();
		if (newsAdminList==null) {
			 log.debug("��������");
	    	 throw new VideoException("���Ų����ڣ�");
		}
		for (News news : newsAdminList) {
			log.debug("��������:"+news.getNews_Title());
			log.info("�������ʱ����:"+news.getNews_Date());
		}
		model.addAttribute("page",page);
    	model.addAttribute("newsAdminList",newsAdminList);
    	return "newsManage";
	}
	/**
	 * //���������������ɾ��
	 * @return
	 */
	@RequestMapping(value="/newsAdminDelete.do")
	public String delNewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
		String[] ids = request.getParameterValues("newsIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) ʹ��join���������ַ���
    	String[] str2=str.split(",");//����,�������
    	System.out.println("str:"+str.length());
    	Integer[] newsIds=new Integer[str2.length];
    	System.out.println("str2:"+newsIds.length);
    	if (newsIds.length<=0) {
			throw new VideoException("ɾ��ʧ��");
		}
    	for(int i=0;i<str2.length;i++){
    		newsIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("ÿ��newsID:"+newsIds[i]);
    	}
    	System.out.println("newsID:"+newsIds);
    	for (Integer integer : newsIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=newsSearch.delNewsBynewsIdArrayWithAdmin(newsIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("ɾ���ɹ�"+newsIds.length);
			return "redirect:/NewsControl/newsManage.do";
		}
		System.out.println("-----"+newsIds.length);		
    	return "newsManage";
    }

}
