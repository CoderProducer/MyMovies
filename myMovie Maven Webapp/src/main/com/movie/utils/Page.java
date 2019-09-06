package com.movie.utils;

import java.io.Serializable;

public class Page implements Serializable {
    private static final long serialVersionUID = -3198048449643774660L;

    private int pageNow = 1; // ��ǰҳ��

    private int pageSize; // ÿҳ��ʾ��¼������

    private int totalCount; // �ܵļ�¼����

    private int totalPageCount; // �ܵ�ҳ��

    @SuppressWarnings("unused")
    private int startPos; // ��ʼλ�ã���0��ʼ
    
    public Page(){}
    
    //ͨ�����캯�� ���� �ܼ�¼�� �� ��ǰҳ
    public Page(int totalCount, int pageNow) {
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    //ȡ����ҳ������ҳ��=�ܼ�¼��/ÿҳ��ʾ��¼������
    public int getTotalPageCount() {
        totalPageCount = getTotalCount() / getPageSize();
        return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    //ȡ��ѡ���¼�ĳ�ʼλ��
    public int getStartPos() {
        return (pageNow - 1) * pageSize;
    }
    
}

