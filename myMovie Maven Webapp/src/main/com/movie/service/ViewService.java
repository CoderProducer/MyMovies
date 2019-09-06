package com.movie.service;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.View;
import com.movie.utils.LimitPageList;

public interface ViewService {
	 //���ڻ�ȡ�û���������
	 int getViewCountByuserId(Integer userId);
	 /**
	   * ��ȡ��ҳ��¼
	   * @param userId:�û�id
	   * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	   * @return ����page��list����
	   */
	LimitPageList getViewPageList(Integer userId, Integer pageNow);
	/**
	   * ��ȡ��ҳ��¼	   
	   * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	   * @return ����page��list����
	   */
	LimitPageList selectViewsWithAdmin(Integer pageNow);
	//���ڻ�ȡ�û���������
	int getViewCountWithAdmin();
	//�û�����ɾ������
	int delViewByviewIdArray(Integer[] view_IdArray);
	//����Ա����ɾ������
	int delViewByviewIdArrayWithAdmin(Integer[] view_IdArrayAdmin);
	//�û���������
	int addViewByuserId(View view);	 
	 /**
	   * ��ȡ��ҳ��¼
	   * @param videoId:��Ƶid
	   * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	   * @return ����page��list����
	   */
	LimitPageList getViewPageListByvideoId(Integer videoId, Integer pageNow);
	//������Ƶ����ҳ��ȡ�û���������
	int getViewCountByvideoId(Integer videoId);
}
