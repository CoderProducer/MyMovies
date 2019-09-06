package com.movie.utils;


public class Pages<M> {
	//��ǰҳ��,Ĭ��Ϊ��1ҳ
    private int currentPageNo =1;
    //��ҳ��
    private int totalPageCount;
    //�ܼ�¼��
    private int totalCount;
    //ҳ������
    private int pageSize=5;
    //��һҳ
    private int upPageNo;
    //��һҳ
    private int nextPageNo;
    
//    //һҳ�Ľ��
//    private List<M> list;
//    
    
    public int getUpPageNo() {
        return upPageNo;
    }
    public void setUpPageNo(int upPageNo) {
        //�����ǰҳ>1
        if(this.currentPageNo>1){
            this.upPageNo = this.currentPageNo-1;
        }
        
    }
    public int getNextPageNo() {
        return nextPageNo;
    }
    public void setNextPageNo(int nextPageNo) {
        //�����ǰҳ>0��С����ҳ�������������һҳ
        if(this.currentPageNo>0 &&this.currentPageNo<this.totalPageCount){
            this.nextPageNo = currentPageNo+1;
        }
        
    }
//    public List<M> getList() {
//        return list;
//    }
//    public void setList(List<M> list) {
//        this.list = list;
//    }
    public int getCurrentPageNo() {
        return currentPageNo;
    }
    //�����ǰҳ�����0�����õ�ǰҳ��ֵ
    public void setCurrentPageNo(int currentPageNo) {
        if(currentPageNo>0){
            this.currentPageNo = currentPageNo;
        }
        
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
    	//�����趨���ܼ�¼�� ���Եó�����Ҫ��ҳ����
        if(totalCount>0){
            this.totalCount = totalCount;
            this.setTotalPageCountByRs();
//        //�Ƚ����������� ����������Ļ� ��ôҳ���������Ӧ�ü�һҳ
//        totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
        }
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        if(pageSize >0){
            this.pageSize = pageSize;
        }
        
    }
    
    public int getTotalPageCount() {
        return totalPageCount;
    }       
    //������ҳ��
    public void setTotalPageCount(int totalPageCount) {
        
            this.totalPageCount =totalPageCount;
        
        }
    public void setTotalPageCountByRs(){
		if(this.totalCount % this.pageSize == 0){
			this.totalPageCount = this.totalCount / this.pageSize;
		}else if(this.totalCount % this.pageSize > 0){
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}else{
			this.totalPageCount = 0;
		}
	}
    
    
}
