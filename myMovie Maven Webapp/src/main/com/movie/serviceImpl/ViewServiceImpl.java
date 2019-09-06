package com.movie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserDao;
import com.movie.dao.ViewDao;
import com.movie.pojo.View;
import com.movie.service.ViewService;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

@Service
public class ViewServiceImpl implements ViewService {
	
	@Autowired
	private ViewDao viewDao;

	//���ڻ�ȡ�û���������
	@Override
	public int getViewCountByuserId(Integer userId) {		
		return viewDao.getViewCountByuserId(userId);
	}
	//�û���ҳ��ȡ�Լ�������
	@Override
	public LimitPageList getViewPageList(Integer userId, Integer pageNow) {
		LimitPageList viewPageList=new LimitPageList();
		//���ڻ�ȡ�û����������� 
		int viewCount=viewDao.getViewCountByuserId(userId);
		List<View> viList=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCount, pageNow);
			page.setPageSize(10);
			viList=viewDao.selectViewByPage(userId, page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
		System.out.println("�б��С"+viList.size());
		}else{
			page=new Page(viewCount,1);//��ʼ��pageNowΪ1
			page.setPageSize(10);
			viList=viewDao.selectViewByPage(userId, page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������ 
			System.out.println("�б��С"+viList.size());
		}
		viewPageList.setPage(page);
		viewPageList.setList(viList);
		return viewPageList;
	}
	//����Ա��ҳ�û�����
	@Override
	public LimitPageList selectViewsWithAdmin(Integer pageNow) {
		LimitPageList viewAdminList=new LimitPageList();
		//���ڻ�ȡ�û���������
		int viewCountAdmin=viewDao.getViewCountWithAdmin();
		List<View> viewListAdmin=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCountAdmin, pageNow);
			page.setPageSize(10);
			viewListAdmin=viewDao.selectViewsWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
		System.out.println("�б��С"+viewListAdmin.size());
		}else{
			page=new Page(viewCountAdmin,1);//��ʼ��pageNowΪ1
			page.setPageSize(10);
			viewListAdmin=viewDao.selectViewsWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������ 
			System.out.println("�б��С"+viewListAdmin.size());
		}
		viewAdminList.setPage(page);
		viewAdminList.setList(viewListAdmin);
		return viewAdminList;
	}
	//���ڹ���Ա��ȡ�û���������
	@Override
	public int getViewCountWithAdmin() {		
		return viewDao.getViewCountWithAdmin();
	}
	//�û�����ɾ������
	@Override
	public int delViewByviewIdArray(Integer[] view_IdArray) {		
		return viewDao.delViewByviewIdArray(view_IdArray);
	}
	//����Ա����ɾ������
	@Override
	public int delViewByviewIdArrayWithAdmin(Integer[] view_IdArrayAdmin) {		
		return viewDao.delViewByviewIdArrayWithAdmin(view_IdArrayAdmin);
	}
	//�û���������
	@Override
	public int addViewByuserId(View view) {		
		return viewDao.addViewByuserId(view);
	}
	//��Ƶ����ҳ�û����۷�ҳչʾ
	@Override
	public LimitPageList getViewPageListByvideoId(Integer videoId, Integer pageNow) {
		LimitPageList viewPageList2=new LimitPageList();
		//���ڻ�ȡ��Ƶ����ҳ�û��������� 
		int viewCount2=viewDao.getViewCountByvideoId(videoId);
		List<View> viList2=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCount2, pageNow);
			page.setPageSize(10);
			viList2=viewDao.getViewByvideoId(videoId, page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
		System.out.println("�б�2��С"+viList2.size());
		}else{
			page=new Page(viewCount2,1);//��ʼ��pageNowΪ1
			page.setPageSize(10);
			viList2=viewDao.getViewByvideoId(videoId, page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������ 
			System.out.println("�б�2��С"+viList2.size());
		}
		viewPageList2.setPage(page);
		viewPageList2.setList(viList2);
		return viewPageList2;
	}
	//ӵ����Ƶ����ҳ��������Ŀ
	@Override
	public int getViewCountByvideoId(Integer videoId) {		
		return viewDao.getViewCountByvideoId(videoId);
	}

}
