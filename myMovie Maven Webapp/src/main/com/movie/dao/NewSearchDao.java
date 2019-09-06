package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.News;

public interface NewSearchDao {
	
	/**
	 * ��ȡ��������Ŀ
	 */
	int getNewsCount();
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	List<News> getNewsList();
	/**
	 * ����Ա��ҳ��ȡ���ż���
	 * @param startPos
	 * @param pageSize
	 * @return ���ż���
	 */
	List<News> selectNewsWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	/**
	 * ����Ա����ɾ������
	 * @param news_IdArrayAdmin
	 * @return Ӱ������
	 */
	int delNewsBynewsIdArrayWithAdmin(@Param(value = "news_IdArrayAdmin") Integer[] news_IdArrayAdmin);

}
