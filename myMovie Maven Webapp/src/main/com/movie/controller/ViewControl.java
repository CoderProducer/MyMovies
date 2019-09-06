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
	 * �û�������������ҳ���ҳ
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/pinglun.do")
    public String getViewByPage(HttpServletRequest request,HttpSession session,
    		@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{ 	
    	  int userId=(int) request.getSession().getAttribute("userId");
    	  //��ҳ��ȡ����
    	  LimitPageList limitPageViewList = viewService.getViewPageList(userId, pageNow);
	      //��ȡҳ����Ϣ
    	  Page pages = limitPageViewList.getPage();	 	      
	      //ǿ������ת��
	      @SuppressWarnings("unchecked")
		  List<View> viewList = (List<View>) limitPageViewList.getList();
	      if (viewList==null) {
	    	  log.debug("����Ϊ��");
	    	  throw new VideoException("���۲����ڣ�");
		}	     
	      for (View view : viewList) {
			log.debug("����id�ǣ�"+view.getView_Id());
			log.info("����ʱ���ǣ�"+view.getView_Date());
		}	    
	      
	      model.addAttribute("pages", pages);
	      model.addAttribute("viewList", viewList);    		      
          return "pinglun";   	     
    }
    /**
	 * �����������۷�ҳ
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/pinglunManage.do")
    public String getViewAdminPage(@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{
//    	LimitPageList viewsAdminPageList=null;
//    	Page page=null;
    	 //��ҳ��ȡ���۵�����ҳ��
    	LimitPageList viewsAdminPageList=viewService.selectViewsWithAdmin(pageNow);
    	//��ȡҳ����Ϣ
    	Page page=viewsAdminPageList.getPage();
    	 //ǿ������ת��
    	@SuppressWarnings("unchecked")
		List<View> viewAdminList=(List<View>) viewsAdminPageList.getList();
    	if (viewAdminList==null) {
    		 log.debug("����Ϊ��");
	    	  throw new VideoException("���۲����ڣ�");
		}
    	for (View view : viewAdminList) {
			log.debug("������:"+view.getUser().getUser_Name());
			log.info("����ʱ���ǣ�"+view.getView_Date());
		}
    	model.addAttribute("page",page);
    	model.addAttribute("viewAdminList",viewAdminList);
    	return "pinglunManage";
    }
    //�û�����������������ɾ��
    @RequestMapping(value="/viewDelete.do")
    public String delViewsByids(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("ids");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) ʹ��join���������ַ���
    	String[] str2=str.split(",");
    	System.out.println("str:"+str.length());
    	Integer[] viewIds=new Integer[str2.length];
    	System.out.println("str2:"+viewIds.length);
    	if (viewIds.length<=0) {
			throw new VideoException("ɾ��ʧ��");
		}    	
//    	Integer[] viewIds=new Integer[ids.length];
//    	System.out.println("viewId���ȣ�"+viewIds.length);
    	for(int i=0;i<str2.length;i++){
    		viewIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("ÿ��viewID:"+viewIds[i]);
    	}
    	System.out.println("viewID:"+viewIds);
    	for (Integer integer : viewIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=viewService.delViewByviewIdArray(viewIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("ɾ���ɹ�"+viewIds.length);
			return "redirect:/ViewControl/pinglun.do";
		}
		System.out.println("-----"+viewIds.length);		
    	return "pinglun";
    }
    //��������û���������ɾ��
    @RequestMapping(value="/viewAdminDelete.do")
    public String delViewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("viewIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) ʹ��join���������ַ���
    	String[] str2=str.split(",");
    	System.out.println("str:"+str.length());
    	Integer[] viewIds=new Integer[str2.length];
    	System.out.println("str2:"+viewIds.length);
    	if (viewIds.length<=0) {
			throw new VideoException("ɾ��ʧ��");
		}
    	for(int i=0;i<str2.length;i++){
    		viewIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("ÿ��viewID:"+viewIds[i]);
    	}
    	System.out.println("viewID:"+viewIds);
    	for (Integer integer : viewIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=viewService.delViewByviewIdArray(viewIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("ɾ���ɹ�"+viewIds.length);
			return "redirect:/ViewControl/pinglunManage.do";
		}
		System.out.println("-----"+viewIds.length);		
    	return "pinglunManage";
    }
    /**
     * �û�����
     * @param model
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value="/viewPost.do")
    public String movieViewPost(HttpServletRequest request,
    		HttpSession session,Model model) throws ParseException{
    	String viewDetail=request.getParameter("viewDetail");
    	log.debug("���������ǣ�"+viewDetail);
    	int videoId=Integer.parseInt(request.getParameter("videoId"));
    	log.debug("������Ƶid�ǣ�"+videoId);
    	int userId=(int) request.getSession().getAttribute("userId");
    	Date date = new Date();//���ϵͳʱ��.
    	//��ʽ��ʱ��
    	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String nowTime = sdf.format(date);
    	log.debug("����ʱ��1�ǣ�"+nowTime);
    	Date time = sdf.parse( nowTime );
    	log.debug("����ʱ��2�ǣ�"+time);
    	//��view��Ϣ����view������
    	View view=new View();
    	view.setView_Date(time);
    	view.setView_Detail(viewDetail);
    	view.setUserId(userId);
    	view.setVideoId(videoId);
    	log.debug("����id�ǣ�"+view.getView_Id());
    	//ִ����ӷ���
    	int row=viewService.addViewByuserId(view);
    	if (row>0) {
			log.debug("���۳ɹ���");			
		}else{
			log.debug("����ʧ�ܣ�");			
		}
//    	model.addAttribute("row",row);
    	return "redirect:/VideoControl/movieDetail.do?video_Id="+videoId;
    }
    /**
	 * ��Ƶ����ҳ�����۷�ҳ
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/moviePinglun.do")
    public String getViewByPageWithVideoId(HttpServletRequest request,
    		@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{ 	
    	  int videoId=Integer.parseInt(request.getParameter("videoId"));
    	  //��ҳ��ȡ����
    	  LimitPageList limitPageViewList2 = viewService.getViewPageListByvideoId(videoId, pageNow);
    	  System.out.println("��ҳ�����ݴ�С��"+limitPageViewList2.getList().size());
	      //��ȡҳ����Ϣ
    	  Page pages = limitPageViewList2.getPage();	 	      
	      //ǿ������ת��
	      @SuppressWarnings("unchecked")
		  List<View> movieViewList = (List<View>) limitPageViewList2.getList();
	      if (movieViewList==null) {
	    	  log.debug("����Ϊ��");
	    	  throw new VideoException("���۲����ڣ�");
		}	     
	      for (View view : movieViewList) {
			log.debug("����id�ǣ�"+view.getView_Id());
			log.info("����ʱ���ǣ�"+view.getView_Date());
		}	    
	      model.addAttribute("videoId",videoId);
	      System.out.println("videoId�ǣ�"+videoId);
	      model.addAttribute("pages", pages);	      
	      System.out.println("���۵�ǰҳ�ǣ�"+pages.getPageNow());
	      model.addAttribute("movieViewList", movieViewList); 
	      for (View view : movieViewList) {
	    	  System.out.println("����ʱ���ǣ�"+view.getView_Date());
	    	  System.out.println("�������ǣ�"+view.getUser().getUser_Name());	    	  
		}	      
	      return "videoViews";   
    }

}
