package com.movie.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.View;

public interface ViewDao {
	
	/**
	 3      * ��ȡ�û����۷�ҳ��¼
	 4      * @param startPos:�����ݿ��еڼ��п�ʼ��ȡ
	 5      * @param userId:�û�Id
	 6		* @param pageSize:��ȡ������
	 7      * @return ����pageSize�����ݵļ��ϣ������㹻��
	 8      */
	 List<View> selectViewByPage(@Param(value = "userId") Integer userId,
			 @Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //���ڻ�ȡ�û������������û��������ģ�
	 int getViewCountByuserId(@Param(value = "userId") Integer userId);
	 /**
	 3      * ��ȡ�û����۷�ҳ��¼
	 4      * @param startPos:�����ݿ��еڼ��п�ʼ��ȡ
	 5		* @param pageSize:��ȡ������
	 6      * @return ����pageSize�����ݵļ��ϣ������㹻��
	 7      */
	 List<View> selectViewsWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //���ڻ�ȡ�û���������(����ҳ��)
	 int getViewCountWithAdmin();
	 //�û�����ɾ������
	 int delViewByviewIdArray(@Param(value = "view_IdArray") Integer[] view_IdArray);
	 //����Ա����ɾ������
	 int delViewByviewIdArrayWithAdmin(@Param(value = "view_IdArrayAdmin") Integer[] view_IdArrayAdmin);
	 //�û���������
	 int addViewByuserId(View view);
	 /**
	 3      * ����Ƶ����ҳ��ȡ�û����۷�ҳ��¼
	 4      * @param startPos:�����ݿ��еڼ��п�ʼ��ȡ
	 5      * @param videoId:��ƵId
	 6		* @param pageSize:��ȡ������
	 7      * @return ����pageSize�����ݵļ��ϣ������㹻��
	 8      */
	 List<View> getViewByvideoId(@Param(value = "videoId") Integer videoId,
			 @Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //���ڻ�ȡ�û�������������Ƶ����ҳ��
	 int getViewCountByvideoId(@Param(value = "videoId") Integer videoId);
}
