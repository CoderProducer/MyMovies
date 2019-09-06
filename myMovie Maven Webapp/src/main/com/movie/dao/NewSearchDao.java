package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.News;

public interface NewSearchDao {
	
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
	 * @param startPos
	 * @param pageSize
	 * @return 新闻集合
	 */
	List<News> selectNewsWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	/**
	 * 管理员批量删除新闻
	 * @param news_IdArrayAdmin
	 * @return 影响行数
	 */
	int delNewsBynewsIdArrayWithAdmin(@Param(value = "news_IdArrayAdmin") Integer[] news_IdArrayAdmin);

}
