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
	 * 获取新闻集合展示到新闻页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/news.do")
	public String getNewsList(Model model) throws Exception{
		List<News> newsList=null;
		
		newsList=newsSearch.getNewsList();		
		if (newsList==null) {
			throw new VideoException("暂无新闻消息！");
			
		}
		for (News news : newsList) {
			System.out.println("新闻标题是："+news.getNews_Title());
		}
		model.addAttribute("newsList", newsList);
		return "news";
	}
	/**
	 * 管理员分页获取新闻到管理页面
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
    	//分页获取新闻到管理页面
    	newsAdminPageList=newsSearch.selectNewsWithAdmin(pageNow);
    	//获取页码信息
    	page=newsAdminPageList.getPage();
    	//强制类型转换    	
		@SuppressWarnings("unchecked")
		List<News> newsAdminList=(List<News>) newsAdminPageList.getList();
		if (newsAdminList==null) {
			 log.debug("暂无新闻");
	    	 throw new VideoException("新闻不存在！");
		}
		for (News news : newsAdminList) {
			log.debug("新闻名称:"+news.getNews_Title());
			log.info("新闻添加时间是:"+news.getNews_Date());
		}
		model.addAttribute("page",page);
    	model.addAttribute("newsAdminList",newsAdminList);
    	return "newsManage";
	}
	/**
	 * //管理界面新闻批量删除
	 * @return
	 */
	@RequestMapping(value="/newsAdminDelete.do")
	public String delNewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
		String[] ids = request.getParameterValues("newsIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) 使用join方法链接字符串
    	String[] str2=str.split(",");//根据,拆分数组
    	System.out.println("str:"+str.length());
    	Integer[] newsIds=new Integer[str2.length];
    	System.out.println("str2:"+newsIds.length);
    	if (newsIds.length<=0) {
			throw new VideoException("删除失败");
		}
    	for(int i=0;i<str2.length;i++){
    		newsIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("每个newsID:"+newsIds[i]);
    	}
    	System.out.println("newsID:"+newsIds);
    	for (Integer integer : newsIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=newsSearch.delNewsBynewsIdArrayWithAdmin(newsIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("删除成功"+newsIds.length);
			return "redirect:/NewsControl/newsManage.do";
		}
		System.out.println("-----"+newsIds.length);		
    	return "newsManage";
    }

}
