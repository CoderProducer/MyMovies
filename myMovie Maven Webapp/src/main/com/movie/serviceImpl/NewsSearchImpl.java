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
	 * ��ȡ��������Ŀ
	 */
	@Override
	public int getNewsCount() {
		
		return newsSearchDao.getNewsCount();
	}
	/**
	 * ��ȡ��������
	 * @return
	 */
	@Override
	public List<News> getNewsList() {
		
		return newsSearchDao.getNewsList();
	}
	//����Ա��ҳ��ȡ����
	@Override
	public LimitPageList selectNewsWithAdmin(Integer pageNow) {
		LimitPageList newsAdminList=new LimitPageList();
		//���ڻ�ȡ�û����������� 
		int newsCountAdmin=newsSearchDao.getNewsCount();
		List<News> newsListAdmin=new ArrayList<News>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(newsCountAdmin, pageNow);
			page.setPageSize(10);
			newsListAdmin=newsSearchDao.selectNewsWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
		System.out.println("�����б��С"+newsListAdmin.size());
		}else{
			page=new Page(newsCountAdmin,1);//��ʼ��pageNowΪ1
			page.setPageSize(10);
			newsListAdmin=newsSearchDao.selectNewsWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
			System.out.println("�����б��С"+newsListAdmin.size());
		}
		newsAdminList.setPage(page);
		newsAdminList.setList(newsListAdmin);
		return newsAdminList;
	}
	//����Ա����ɾ������
	@Override
	public int delNewsBynewsIdArrayWithAdmin(Integer[] news_IdArrayAdmin) {		
		return newsSearchDao.delNewsBynewsIdArrayWithAdmin(news_IdArrayAdmin);
	}

}
