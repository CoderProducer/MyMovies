package com.movie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/PageVisitControl")
public class PageVisitControl{
          
	
	@RequestMapping(value="/UserLogin.do")
	   public String login(){
		   return "UserLogin";
	   }
	 @RequestMapping(value="/reg.do")
	public String regPage(){
		return "reg";
	}
	 @RequestMapping(value="/checkUserName.do")
		public String checkUserName(){
			return "reg";
		}

	@RequestMapping(value="/AdminLogin.do")
	public String adminLogPage(){
		return "AdminLogin";
	}
	
	@RequestMapping(value="/index.do")
	public String indexPage(){
		return "index";
	}
	
	@RequestMapping(value="/admin.do")
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping(value="/usersManage.do")
	public String usersManagePage(){
		return "usersManage";
	}
	@RequestMapping(value="/usersDeleteById.do")
	public String usersDeleteById(){
		return "usersManage";
	}
	@RequestMapping(value="/manage.do")
	public String updateUsersById(){
		return "manage";
	}
	@RequestMapping(value="/manage2.do")
	public String getUsersById(){
		return "manage2";
	}
	@RequestMapping(value="/history.do")
	public String findAllByuserId(){
		return "history";
	}
	@RequestMapping(value="/newsManage.do")
	public String newsManagePage(){
		return "newsManage";
	}
	@RequestMapping(value="/newsA.do")
	public String newsAPage(){
		return "newsA";
	}
	@RequestMapping(value="/pinglunManage.do")
	public String pinglunManagePage(){
		return "pinglunManage";
	}
	
	@RequestMapping(value="/pinglun.do")
	public String pinglunPage(){
		return "pinglun";
	}
	@RequestMapping(value="/searchList.do")
	public String searchPage(){
		return "searchList";
	}
	
	@RequestMapping(value="/comic.do")
	public String getComic(){
		return "comic";
	}
	
	@RequestMapping(value="/moviesAdd.do")
	public String addVideo(){
		return "moviesAdd";
	}
	
	@RequestMapping(value="/download.do")
	public String findDownloadByuserId(){
		return "download";
	}
	
	@RequestMapping(value="/videosManage.do")
	public String getVideos(){
		return "videosManage";
	}
	
	@RequestMapping(value="/movie.do")
	public String getMovies(){
		return "movie";
	}
	
	@RequestMapping(value="/movieDetail.do")
	public String getMovieDetail(){
		return "movieDetail";
	}
	
	@RequestMapping(value="/news.do")
	public String getNews(){
		return "news";
	}	
	
	@RequestMapping(value="/player.do")
	public String videoPlay(){
		return "player";
	}


	@RequestMapping(value="/series.do")
	public String getSeries(){
		return "series";
	}
	
	@RequestMapping(value="/tvAndComicDetail.do")
	public String getTvDetail(){
		return "tvAndComicDetail";
	}
	
	@RequestMapping(value="/updatePassword.do")
	public String updatePwd(){
		return "updatePassword";
	}
	
	@RequestMapping(value="/variety.do")
	public String getVariety(){
		return "variety";
	}
	
	@RequestMapping(value="/varietyDetail.do")
	public String getVarietyDetail(){
		return "varietyDetail";
	}
	
	@RequestMapping(value="/upload.do")
	public String uploadPage(){
		return "upload";
	}
	
	@RequestMapping(value="/userExit.do")
	public String exitPage(HttpSession session){
		session.removeAttribute("user");
		//session.removeAttribute("password");
		return "redirect:/VideoControl/index.do";
	}
	
}
