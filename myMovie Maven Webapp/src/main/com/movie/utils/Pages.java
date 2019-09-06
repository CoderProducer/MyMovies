package com.movie.utils;


public class Pages<M> {
	//当前页码,默认为第1页
    private int currentPageNo =1;
    //总页数
    private int totalPageCount;
    //总记录数
    private int totalCount;
    //页面容量
    private int pageSize=5;
    //上一页
    private int upPageNo;
    //下一页
    private int nextPageNo;
    
//    //一页的结果
//    private List<M> list;
//    
    
    public int getUpPageNo() {
        return upPageNo;
    }
    public void setUpPageNo(int upPageNo) {
        //如果当前页>1
        if(this.currentPageNo>1){
            this.upPageNo = this.currentPageNo-1;
        }
        
    }
    public int getNextPageNo() {
        return nextPageNo;
    }
    public void setNextPageNo(int nextPageNo) {
        //如果当前页>0且小于总页数，则可以有下一页
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
    //如果当前页码大于0才设置当前页码值
    public void setCurrentPageNo(int currentPageNo) {
        if(currentPageNo>0){
            this.currentPageNo = currentPageNo;
        }
        
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
    	//根据设定的总记录数 可以得出所需要的页面数
        if(totalCount>0){
            this.totalCount = totalCount;
            this.setTotalPageCountByRs();
//        //先进行求余运算 如果有余数的话 那么页面的数量就应该加一页
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
    //设置总页数
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
