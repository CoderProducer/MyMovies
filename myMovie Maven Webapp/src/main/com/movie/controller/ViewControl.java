package com.movie.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.Exception.VideoException;

import com.movie.pojo.View;
import com.movie.service.ViewService;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/ViewControl")
public class ViewControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(ViewControl.class);
	
	@Autowired
	private ViewService viewService;
	
	/**
	 * 用户个人中心评论页面分页
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/pinglun.do")
    public String getViewByPage(HttpServletRequest request,HttpSession session,
    		@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{ 	
    	  int userId=(int) request.getSession().getAttribute("userId");
    	  //分页获取评论
    	  LimitPageList limitPageViewList = viewService.getViewPageList(userId, pageNow);
	      //获取页码信息
    	  Page pages = limitPageViewList.getPage();	 	      
	      //强制类型转换
	      @SuppressWarnings("unchecked")
		  List<View> viewList = (List<View>) limitPageViewList.getList();
	      if (viewList==null) {
	    	  log.debug("评论为空");
	    	  throw new VideoException("评论不存在！");
		}	     
	      for (View view : viewList) {
			log.debug("评论id是："+view.getView_Id());
			log.info("评论时间是："+view.getView_Date());
		}	    
	      
	      model.addAttribute("pages", pages);
	      model.addAttribute("viewList", viewList);    		      
          return "pinglun";   	     
    }
    /**
	 * 管理界面的评论分页
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/pinglunManage.do")
    public String getViewAdminPage(@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{
//    	LimitPageList viewsAdminPageList=null;
//    	Page page=null;
    	 //分页获取评论到管理页面
    	LimitPageList viewsAdminPageList=viewService.selectViewsWithAdmin(pageNow);
    	//获取页码信息
    	Page page=viewsAdminPageList.getPage();
    	 //强制类型转换
    	@SuppressWarnings("unchecked")
		List<View> viewAdminList=(List<View>) viewsAdminPageList.getList();
    	if (viewAdminList==null) {
    		 log.debug("评论为空");
	    	  throw new VideoException("评论不存在！");
		}
    	for (View view : viewAdminList) {
			log.debug("评论者:"+view.getUser().getUser_Name());
			log.info("评论时间是："+view.getView_Date());
		}
    	model.addAttribute("page",page);
    	model.addAttribute("viewAdminList",viewAdminList);
    	return "pinglunManage";
    }
    //用户个人中心评论批量删除
    @RequestMapping(value="/viewDelete.do")
    public String delViewsByids(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("ids");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) 使用join方法链接字符串
    	String[] str2=str.split(",");
    	System.out.println("str:"+str.length());
    	Integer[] viewIds=new Integer[str2.length];
    	System.out.println("str2:"+viewIds.length);
    	if (viewIds.length<=0) {
			throw new VideoException("删除失败");
		}    	
//    	Integer[] viewIds=new Integer[ids.length];
//    	System.out.println("viewId长度："+viewIds.length);
    	for(int i=0;i<str2.length;i++){
    		viewIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("每个viewID:"+viewIds[i]);
    	}
    	System.out.println("viewID:"+viewIds);
    	for (Integer integer : viewIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=viewService.delViewByviewIdArray(viewIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("删除成功"+viewIds.length);
			return "redirect:/ViewControl/pinglun.do";
		}
		System.out.println("-----"+viewIds.length);		
    	return "pinglun";
    }
    //管理界面用户评论批量删除
    @RequestMapping(value="/viewAdminDelete.do")
    public String delViewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("viewIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) 使用join方法链接字符串
    	String[] str2=str.split(",");
    	System.out.println("str:"+str.length());
    	Integer[] viewIds=new Integer[str2.length];
    	System.out.println("str2:"+viewIds.length);
    	if (viewIds.length<=0) {
			throw new VideoException("删除失败");
		}
    	for(int i=0;i<str2.length;i++){
    		viewIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("每个viewID:"+viewIds[i]);
    	}
    	System.out.println("viewID:"+viewIds);
    	for (Integer integer : viewIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=viewService.delViewByviewIdArray(viewIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("删除成功"+viewIds.length);
			return "redirect:/ViewControl/pinglunManage.do";
		}
		System.out.println("-----"+viewIds.length);		
    	return "pinglunManage";
    }
    /**
     * 用户评论
     * @param model
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value="/viewPost.do")
    public String movieViewPost(HttpServletRequest request,
    		HttpSession session,Model model) throws ParseException{
    	String viewDetail=request.getParameter("viewDetail");
    	log.debug("评论内容是："+viewDetail);
    	int videoId=Integer.parseInt(request.getParameter("videoId"));
    	log.debug("评论视频id是："+videoId);
    	int userId=(int) request.getSession().getAttribute("userId");
    	Date date = new Date();//获得系统时间.
    	//格式化时间
    	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String nowTime = sdf.format(date);
    	log.debug("评论时间1是："+nowTime);
    	Date time = sdf.parse( nowTime );
    	log.debug("评论时间2是："+time);
    	//将view信息放入view对象中
    	View view=new View();
    	view.setView_Date(time);
    	view.setView_Detail(viewDetail);
    	view.setUserId(userId);
    	view.setVideoId(videoId);
    	log.debug("评论id是："+view.getView_Id());
    	//执行添加方法
    	int row=viewService.addViewByuserId(view);
    	if (row>0) {
			log.debug("评论成功！");			
		}else{
			log.debug("评论失败！");			
		}
//    	model.addAttribute("row",row);
    	return "redirect:/VideoControl/movieDetail.do?video_Id="+videoId;
    }
    /**
	 * 视频详情页面评论分页
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/moviePinglun.do")
    public String getViewByPageWithVideoId(HttpServletRequest request,
    		@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{ 	
    	  int videoId=Integer.parseInt(request.getParameter("videoId"));
    	  //分页获取评论
    	  LimitPageList limitPageViewList2 = viewService.getViewPageListByvideoId(videoId, pageNow);
    	  System.out.println("分页的数据大小："+limitPageViewList2.getList().size());
	      //获取页码信息
    	  Page pages = limitPageViewList2.getPage();	 	      
	      //强制类型转换
	      @SuppressWarnings("unchecked")
		  List<View> movieViewList = (List<View>) limitPageViewList2.getList();
	      if (movieViewList==null) {
	    	  log.debug("评论为空");
	    	  throw new VideoException("评论不存在！");
		}	     
	      for (View view : movieViewList) {
			log.debug("评论id是："+view.getView_Id());
			log.info("评论时间是："+view.getView_Date());
		}	    
	      model.addAttribute("videoId",videoId);
	      System.out.println("videoId是："+videoId);
	      model.addAttribute("pages", pages);	      
	      System.out.println("评论当前页是："+pages.getPageNow());
	      model.addAttribute("movieViewList", movieViewList); 
	      for (View view : movieViewList) {
	    	  System.out.println("评论时间是："+view.getView_Date());
	    	  System.out.println("评论者是："+view.getUser().getUser_Name());	    	  
		}	      
	      return "videoViews";   
    }

}
