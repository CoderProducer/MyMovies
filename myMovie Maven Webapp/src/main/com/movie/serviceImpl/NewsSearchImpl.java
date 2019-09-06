package com.movie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.NewSearchDao;
import com.movie.pojo.News;
import com.movie.service.NewsSearch;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

@Service
public class NewsSearchImpl implements NewsSearch {
	@Autowired
	private NewSearchDao newsSearchDao;
	
	/**
	 * 获取新闻总数目
	 */
	@Override
	public int getNewsCount() {
		
		return newsSearchDao.getNewsCount();
	}
	/**
	 * 获取最新新闻
	 * @return
	 */
	@Override
	public List<News> getNewsList() {
		
		return newsSearchDao.getNewsList();
	}
	//管理员分页获取新闻
	@Override
	public LimitPageList selectNewsWithAdmin(Integer pageNow) {
		LimitPageList newsAdminList=new LimitPageList();
		//用于获取用户评论总数数 
		int newsCountAdmin=newsSearchDao.getNewsCount();
		List<News> newsListAdmin=new ArrayList<News>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(newsCountAdmin, pageNow);
			page.setPageSize(10);
			newsListAdmin=newsSearchDao.selectNewsWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
		System.out.println("新闻列表大小"+newsListAdmin.size());
		}else{
			page=new Page(newsCountAdmin,1);//初始化pageNow为1
			page.setPageSize(10);
			newsListAdmin=newsSearchDao.selectNewsWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
			System.out.println("新闻列表大小"+newsListAdmin.size());
		}
		newsAdminList.setPage(page);
		newsAdminList.setList(newsListAdmin);
		return newsAdminList;
	}
	//管理员批量删除新闻
	@Override
	public int delNewsBynewsIdArrayWithAdmin(Integer[] news_IdArrayAdmin) {		
		return newsSearchDao.delNewsBynewsIdArrayWithAdmin(news_IdArrayAdmin);
	}

}
