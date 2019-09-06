package com.movie.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.Exception.VideoException;
import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.service.UserService;
import com.movie.service.VideoSearch;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;
import com.movie.utils.Pages;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/UserControl")
public class UserControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(UserControl.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private VideoSearch videoSearch;
	
//	@RequestMapping(value="/usersManage.do")
//	public String getUserList(Model model){		
//		List<User> userList = userService.getUserList();
//		
//		model.addAttribute("userList",userList);
//		
//		return "usersManage";		
//	}
	/**
	 * 分页
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/usersManage.do")
    public String getUserByPage(
    		@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception { 	
    	  LimitPageList limitPageStuList = userService.getLimitPageList(pageNow);
	      Page page = limitPageStuList.getPage();
	      //强制类型转换
	      @SuppressWarnings("unchecked")
		  List<User> uList = (List<User>) limitPageStuList.getList();
	      if (uList==null) {
	    	  throw new VideoException("暂无用户！");
		}
	      for (User user : uList) {
	    	  log.debug("名字是"+user.getUser_Name());
	    	  log.info("id是："+user.getUser_Id());
		}
	      
	      model.addAttribute("page", page);
	      model.addAttribute("uList", uList);    		      
        return "usersManage";    	     
	
}

		
//		/**
//		 * 
//		 * 
//		 * 根据ID查找用户
//		 * @param user
//		 * @return
//		 */
//		@RequestMapping("usersManage.do")
//		public String getUserByName(HttpServletRequest request,HttpServletResponse response, Model model,
//				@RequestParam("user_Name") Integer user_Name) {
//			User userGet = userService.getUserByuserId(user_Name);
//			model.addAttribute("userGet", userGet);
//			return "usersManage";
//		}
//		
	    @RequestMapping(value="/manage.do")
		public String getUserById(HttpServletRequest request,HttpSession session, Model model) {
	    	int uId=(int) request.getSession().getAttribute("userId");
			User userGet = userService.getUserByuserId(uId);
			model.addAttribute("userGet", userGet);
			return "manage";
		}
		@RequestMapping(value="/manage2.do",method=RequestMethod.POST)
		public String updateUserByUser(HttpServletRequest request,
				@RequestParam(value="user_Name") String user_Name,
				@RequestParam(value="user_Email") String user_Email,
				@RequestParam(value="user_Tel") String user_Tel,
				@RequestParam(value="user_QQ") String user_QQ,
				Model model){		
			int uId=(int) request.getSession().getAttribute("userId");
			User user=new User();
			user.setUser_Id(uId);
			user.setUser_Name(user_Name);
			user.setUser_Email(user_Email);
			user.setUser_Tel(user_Tel);
			user.setUser_QQ(user_QQ);
			int updateRows = userService.updateUser(user);
			if (updateRows>0) {
				log.debug("更新成功！");
				model.addAttribute("userGet",user);
				return "manage";
			}else{
				return "manage2";
			}			
		}
		
		/**
		 * 删除用户
	     * 带事务控制
		 * @param user
		 * @return
		 */
		@RequestMapping(value="/usersDeleteById.do")
		public String deleteUserByUserId(HttpServletRequest request,HttpServletResponse response, Model model){
			User user=new User();
			user.setUser_Id(Integer.parseInt(request.getParameter("user_Id")));
			int delUserRows=userService.deleteUserByUserId(user.getUser_Id());
			if (delUserRows>0) {
				log.debug("删除成功");;
				return "redirect:/UserControl/usersManage.do";
			}
			return "usersManage";
		} 
		/**
		 * 搜索框搜索分页列表
		 * @param model
		 * @param videoSearch
		 * @param pageIndex
		 * @return
		 */
		@RequestMapping(value="/searchList.do")
		public String getVideoListByName(Model model,
				@RequestParam(value="videoSearch",required=false) String videoSearch, 
				@RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception{
			log.info("名字是：--->>"+videoSearch);
			List<Video> videoList=null;
			//设置页面容量
			int pageSize=10;
			//当前页码
			int currentPageNo=1;
			if (pageIndex!=null) {
				try {
					currentPageNo=Integer.parseInt(pageIndex); 
				} catch (NumberFormatException  e) {
					  return "redirect:/UserControl/searchList.do";
						//response.sendRedirect("searchList.jsp");
				}
			}
			//总数量（表）
			int totalCount=userService.getVideoCount(videoSearch);
			//总页数
			Pages<Video> pages=new Pages<Video>();
		
			pages.setCurrentPageNo(currentPageNo);
			pages.setPageSize(pageSize);
			pages.setTotalCount(totalCount);
			int totalPageCount=pages.getTotalPageCount();
			//控制首页和尾页
			if (currentPageNo<1) {
				currentPageNo=1;
			}else if (currentPageNo>totalPageCount) {
				currentPageNo=totalPageCount;
			}
			videoList=userService.selectVideoPageByName(videoSearch, currentPageNo, pageSize);
			if (videoList==null) {
				throw new VideoException("查询的视频不存在！");
				
			}
			for (Video video : videoList) {
				log.info("视频名称："+video.getVideo_Name()+video.getVideo_KeyWords());
			}
			model.addAttribute("videoList", videoList);
			model.addAttribute("videoSearch", videoSearch);
			model.addAttribute("currentPageNo", currentPageNo);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("totalPageCount", totalPageCount);
			return "searchList";
		} 
		/**
		 * 观看记录
		 * @param request
		 * @param model
		 * @return
		 */
		@RequestMapping(value="/history.do")
		public String findAllByuserId(HttpServletRequest request,				
				Model model) throws Exception{
			User user=null;
			user=(User) request.getSession().getAttribute("user");
			int uId=user.getUser_Id();
			log.info("uId");
			List<History> hList=new ArrayList<History>();
			List<Video> vlist=new ArrayList<Video>();
			
//			Video v=new Video();
//			int videoId;
			hList=userService.findAllByuserId(uId);
			if (hList==null) {				
				throw new VideoException("观看历史为零！");
			}
			System.out.println("——————————————————"+hList.size());			
//			for (History h : hList) {				
//				log.info("——————————————————"+h.getVideoId());
//				videoId=h.getVideoId();
//				v=videoSearch.getVideoList(videoId);
//				vlist.add(v);
//				h.setvList(vlist);
//			}
//			for (Video video : vlist) {
//				log.info("video.getVideo_Name()------>"+video.getVideo_Name());
//			}
			int hiscount;
			hiscount=userService.getHistoryCount(uId);
			model.addAttribute("hiscount",hiscount);
			model.addAttribute("vlist",vlist);			
			model.addAttribute("hList",hList);			
			return "history";
		} 
		/**
		 * 下载记录
		 * @param request
		 * @param model
		 * @return
		 */
		@RequestMapping(value="/download.do")
		public String findDownloadByuserId(HttpServletRequest request,				
				Model model) throws Exception{
			User user=null;
			user=(User) request.getSession().getAttribute("user");
			int uId=user.getUser_Id();
			log.info("uId");
//			Integer _userId=0;		
//			if (user_Id!=null) {
//				_userId=Integer.parseInt(user_Id);			
//			}
//			int uId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
			List<Download> dList=new ArrayList<Download>();
			List<Video> dvlist=new ArrayList<Video>();
			
			Video v=new Video();
			int videoId;
			dList=userService.findDownloadByuserId(uId);
			if (dList==null) {				
				throw new VideoException("下载历史为空！");
			}
			System.out.println("——————————————————"+dList.size());			
			for (Download d : dList) {
				System.out.println(d);
				log.info("——————————————————"+d.getVideoId());
//				dvlist=d.getvList();
				videoId=d.getVideoId();
				v=videoSearch.getVideoList(videoId);
				dvlist.add(v);
				d.setvList(dvlist);
//				v=videoSearch.getVideoList(h.getVideoId());
//				vlist.add(v);	
//				vlist=h.getvList();
//				for (Video video : vlist) {
//					log.debug("--------"+video.getVideo_Name());		
//				}
			}
			for (Video video : dvlist) {
				log.info("video.getVideo_Name()------>"+video.getVideo_Name());
			}
			int downcount;
			downcount=userService.getDownloadCount(uId);
			model.addAttribute("downcount",downcount);
			model.addAttribute("dvlist",dvlist);			
			model.addAttribute("dList",dList);			
			return "download";
		} 
		/**
		 * 更新密码
		 * @param request
		 * @param model
		 * @return
		 */
		@RequestMapping(value="/updatePassword.do")
		public String updatePassword(HttpServletRequest request,
				@RequestParam(value="oldPassword") String oldPassword,
				@RequestParam(value="newPassword") String newPassword,
				@RequestParam(value="checkPassword") String checkPassword,
				Model model){
			//获取userid
			int userId=(int) request.getSession().getAttribute("userId");
			log.debug("userId是:"+userId);
//			//获取输入的旧密码
//			String oldPwd=(String) request.getAttribute("oldPassword");
//			log.debug("oldPwd是:"+oldPwd);
//			//获取输入的新密码
//			String newPwd=(String) request.getAttribute("newPassword");
//			log.debug("newPwd是:"+newPwd);
//			//获取输入的确认密码
//			String checkPwd=(String) request.getAttribute("checkPassword");
//			log.debug("checkPwd是:"+checkPwd);
			//从数据库获取密码来确定输入的密码是否正确
			String sqlPwd=userService.getUserByuserId(userId).getUser_Password();
			log.debug("sqlPwd是:"+sqlPwd);
			//定义一个count
			int count=0;
			if (oldPassword.equals(sqlPwd)) {
				log.debug("数据库中有此密码");
				if (!oldPassword.equals(newPassword)&&newPassword.equals(checkPassword)) {
					log.debug("密码匹配成功");
					count=userService.updateUserPassword(userId, newPassword);
					log.debug("count是:"+count);
					if (count>0) {
						System.out.println("更新成功！");
						return "redirect:/UserControl/manage.do";	
					}					
				}
			}
			return "updatePassword";
		}	
		
}
