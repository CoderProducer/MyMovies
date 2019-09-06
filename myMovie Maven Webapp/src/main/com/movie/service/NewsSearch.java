package com.movie.service;

import java.util.List;


import com.movie.pojo.News;
import com.movie.utils.LimitPageList;

public interface NewsSearch {
	/**
	 * 获取新闻总数目
	 */
	int getNewsCount();
	/**
	 * 获取最新新闻
	 * @return
	 */
	List<News> getNewsList();
	/**
	 * 管理员分页获取新闻集合
	 * @param pageNow:当前页码，若为null值，则为1
	 * @return 返回page和list集合
	 */
	LimitPageList selectNewsWithAdmin(Integer pageNow);
	/**
	 * 管理员批量删除新闻
	 * @param news_IdArrayAdmin
	 * @return 影响行数
	 */
	int delNewsBynewsIdArrayWithAdmin(Integer[] news_IdArrayAdmin);

}
