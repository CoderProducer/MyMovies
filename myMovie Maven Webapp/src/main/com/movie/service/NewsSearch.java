package com.movie.service;

import java.util.List;


import com.movie.pojo.News;
import com.movie.utils.LimitPageList;

public interface NewsSearch {
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
	 * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	 * @return ����page��list����
	 */
	LimitPageList selectNewsWithAdmin(Integer pageNow);
	/**
	 * ����Ա����ɾ������
	 * @param news_IdArrayAdmin
	 * @return Ӱ������
	 */
	int delNewsBynewsIdArrayWithAdmin(Integer[] news_IdArrayAdmin);

}
