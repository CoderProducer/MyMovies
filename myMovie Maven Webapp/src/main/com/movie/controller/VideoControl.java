package com.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.Exception.VideoException;
import com.movie.pojo.News;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;
import com.movie.service.VideoSearch;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;
import com.movie.utils.Pages;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/VideoControl")
public class VideoControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(VideoControl.class);
	
	@Autowired
	private VideoSearch vS;
	/**
	 * 搜索电影
	 * @param request
	 * @param model country type ageTime pageIndex
	 * @return
	 */
    @RequestMapping("movie.do")
    public String getmvoie(
    		@RequestParam(value="country",required=false) String country,
    		@RequestParam(value="type",required=false) String type,
    		@RequestParam(value="ageTime",required=false) String ageTime,
    		@RequestParam(value="pageIndex",required=false) String pageIndex,
    		Model model) throws Exception {
    	List<Video> movieList=null;
    	//设置页面容量
		int pageSize=10;
		//当前页码
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/movie.do";
					//response.sendRedirect("movie.do");
			}
		}
		//总数量（表）
		int totalCount=vS.getmovieCount(country, type, ageTime);
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
		movieList=vS.getmovieByType(country, type, ageTime, currentPageNo, pageSize);
		if (movieList==null) {
			throw new VideoException("该类型的电影不存在！");
		}
		for (Video video : movieList) {
			System.out.println("视频名称："+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("movieList", movieList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "movie";
    }
    
    /**
	 * 搜索综艺
	 * @param request
	 * @param model country type ageTime pageIndex
	 * @return
	 */
    @RequestMapping("variety.do")
    public String getvariety(
    		@RequestParam(value="country",required=false) String country,
    		@RequestParam(value="type",required=false) String type,
    		@RequestParam(value="ageTime",required=false) String ageTime,
    		@RequestParam(value="pageIndex",required=false) String pageIndex,
    		Model model) throws Exception{
    	List<Video> varietyList=null;
    	//设置页面容量
		int pageSize=10;
		//当前页码
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/variety.do";
					//response.sendRedirect("movie.do");
			}
		}
		//总数量（表）
		int totalCount=vS.getvarietyCount(country, type, ageTime);
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
		varietyList=vS.getvarietyByType(country, type, ageTime, currentPageNo, pageSize);
		if (varietyList==null) {
			throw new VideoException("该类型的综艺不存在！");
		}
		for (Video video : varietyList) {
			System.out.println("视频名称："+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("varietyList", varietyList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "variety";
    }
    
    /**
	 * 搜索电视剧
	 * @param request
	 *@param model country type ageTime pageIndex
	 * @return
	 */
    @RequestMapping("series.do")
    public String getseries(
    		@RequestParam(value="country",required=false) String country,
    		@RequestParam(value="type",required=false) String type,
    		@RequestParam(value="ageTime",required=false) String ageTime,
    		@RequestParam(value="pageIndex",required=false) String pageIndex,
    		Model model) throws Exception{
    	List<Video> tvList=null;
    	//设置页面容量
		int pageSize=10;
		//当前页码
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/series.do";
					//response.sendRedirect("movie.do");
			}
		}
		//总数量（表）
		int totalCount=vS.gettvCount(country, type, ageTime);
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
		tvList=vS.getmovieByType(country, type, ageTime, currentPageNo, pageSize);
		if (tvList==null) {
			throw new VideoException("该类型的电视剧不存在！");
		}
		for (Video video : tvList) {
			System.out.println("视频名称："+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("tvList", tvList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "series";
    }
    
    /**
	 * 搜索动漫
	 * @param request
	 *@param model country type ageTime pageIndex
	 * @return
	 */
    @RequestMapping("comic.do")
    public String getcomic(
    		@RequestParam(value="country",required=false) String country,
    		@RequestParam(value="type",required=false) String type,
    		@RequestParam(value="ageTime",required=false) String ageTime,
    		@RequestParam(value="pageIndex",required=false) String pageIndex,
    		Model model) throws Exception{
    	List<Video> comicList=null;
    	//设置页面容量
		int pageSize=10;
		//当前页码
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/comic.do";
					//response.sendRedirect("movie.do");
			}
		}
		//总数量（表）
		int totalCount=vS.getcomicCount(country, type, ageTime);
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
		comicList=vS.getcomicByType(country, type, ageTime, currentPageNo, pageSize);
		if (comicList==null) {
			throw new VideoException("该类型的动漫不存在！");
		}

		for (Video video : comicList) {
			System.out.println("视频名称："+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("comicList", comicList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "comic";
    }
    /**
	 * 搜索首页视频
	 * @return 首页视频集合
	 */
    @RequestMapping(value="/index.do")
	public String getmovieList(Model model) throws Exception{
		List<Video> mIndexList1=null;
		List<Video> mIndexList2=null;
		List<Video> mIndexList3=null;
		List<Video> mIndexList4=null;
		List<Video> mIndexList5=null;
		
		// 按评分获取12部电影放到首页	 
		mIndexList1=vS.getMovieByPoints();	
		// 按热点获取12部电影放到首页		
		mIndexList2=vS.getMovieByHotPoints();	
		// 按时间获取12部电影放到首页	 
		mIndexList3=vS.getMovieByTime();	
		// 随机获取5部电影放到首页轮播处
		mIndexList4=vS.getMovieRandom();
		// 随机获取9部电影放到首页
		mIndexList5=vS.getMovieRandom2();
		if (mIndexList1==null) {
			throw new VideoException("暂无该类视频！");			
		}				
		if (mIndexList2==null) {
			throw new VideoException("暂无该类视频！");			
		}
		if (mIndexList3==null) {
			throw new VideoException("暂无该类视频！");			
		}	
		if (mIndexList4==null) {
			throw new VideoException("暂无该类视频！");			
		}
		if (mIndexList5==null) {
			throw new VideoException("暂无该类视频！");					
		}
		for (Video video1 : mIndexList1) {
			System.out.println("视频名称是："+video1.getVideo_Name());
		}
		for (Video video2 : mIndexList2) {
			System.out.println("视频名称是："+video2.getVideo_Name());
		}
		for (Video video3 : mIndexList3) {
			System.out.println("视频名称是："+video3.getVideo_Name());
		}	
		for (Video video4: mIndexList4) {
			System.out.println("视频名称："+video4.getVideo_Name());
		}
		for (Video video5: mIndexList5) {
			System.out.println("视频名称："+video5.getVideo_Name());
		}
		model.addAttribute("mIndexList1", mIndexList1);	
		model.addAttribute("mIndexList2", mIndexList2);
		model.addAttribute("mIndexList3", mIndexList3);
		model.addAttribute("mIndexList4", mIndexList4);
		model.addAttribute("mIndexList5", mIndexList5);
		return "index";
	}
//    /**
//	 * 搜索首页视频
//	 * @return 首页按评分查询视频集合
//	 */
//    @RequestMapping(value="/PointMovie.do")
//	public String getindexMovieList(Model model) throws Exception{
//		List<Video> mIndexList1=null;		
//		// 按评分获取12部电影放到首页	 
//		mIndexList1=vS.getMovieByPoints();	
//		if (mIndexList1==null) {
//			throw new VideoException("暂无该类视频！");			
//		}		
//		for (Video video1 : mIndexList1) {
//			System.out.println("视频名称是："+video1.getVideo_Name());
//		}		
//		model.addAttribute("mIndexList1", mIndexList1);		
//		return "index";
//	}
//    /**
//	 * 搜索首页视频
//	 * @return 首页按时间查询视频集合
//	 */
//    @RequestMapping(value="/TimeMovie.do")
//	public String getTimeMovieList(Model model) throws Exception{
//		List<Video> mIndexList3=null;		
//		// 按评分获取12部电影放到首页	 
//		mIndexList3=vS.getMovieByPoints();	
//		if (mIndexList3==null) {
//			throw new VideoException("暂无该类视频！");			
//		}		
//		for (Video video3 : mIndexList3) {
//			System.out.println("视频名称是："+video3.getVideo_Name());
//		}		
//		model.addAttribute("mIndexList3", mIndexList3);		
//		return "index";
//	}
    @RequestMapping(value="/movieDetail.do")
    public String getMovieDetail(Model model,HttpServletRequest request) throws Exception{    	
    	int videoId=Integer.parseInt(request.getParameter("video_Id"));
    	System.out.println("视频id"+videoId);
    	log.debug("videoId:"+videoId);
    	Video vDetail=new Video();    	
    	vDetail=vS.findDetailByVideoId(videoId);    	
    	if (vDetail.getActorList().size()==0) {
    		System.out.println("----!"); 
    		log.debug("----");    		
			throw new VideoException("资源出错");			
		}
        System.out.println("演员人数:"+vDetail.getActorList().size());		
    	System.out.println("视频id:"+vDetail.getVideo_Id());
//    	if (mDetail!=null) {
//    		log.debug("演员名字id是:"+mDetail.getActorId());
//    		System.out.println("视频详情id:"+mDetail.getVideoId());
//		}    	
    	System.out.println("视频详情id:"+vDetail.getVideo_Id()); 		
    	model.addAttribute("vDetail",vDetail);
    	model.addAttribute("mDetail",vDetail.getActorList());    	
    	return "movieDetail";
    }
    /**
     * 管理界面的视频分页
     * @param pageNow
     * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value="videosManage.do")
    public String selectVideoWithAdmin(@RequestParam(value="pageNow",required=false) Integer pageNow,
    		Model model) throws Exception{
    	LimitPageList videoAdminPageList=null;
    	Page page=null;
    	//分页获取视频到管理页面
    	videoAdminPageList=vS.selectVideoWithAdmin(pageNow);
    	//获取页码信息
    	page=videoAdminPageList.getPage();
    	//强制类型转换    	
		@SuppressWarnings("unchecked")
		List<Video> videoAdminList=(List<Video>) videoAdminPageList.getList();
		if (videoAdminList==null) {
			 log.debug("暂无视频");
	    	 throw new VideoException("视频不存在！");
		}
		for (Video video : videoAdminList) {
			log.debug("视频名称:"+video.getVideo_Name());
			log.info("视频上映时间是："+video.getVideo_PictureAddress());
		}
		model.addAttribute("page",page);
    	model.addAttribute("videoAdminList",videoAdminList);
    	return "videosManage";
    }
	//管理界面视频批量删除
    @RequestMapping(value="/videoAdminDelete.do")
    public String delViewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("videoIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) 使用join方法链接字符串
    	String[] str2=str.split(",");//根据,拆分数组
    	System.out.println("str:"+str.length());
    	Integer[] videoIds=new Integer[str2.length];
    	System.out.println("str2:"+videoIds.length);
    	if (videoIds.length<=0) {
			throw new VideoException("删除失败");
		}
    	for(int i=0;i<str2.length;i++){
    		videoIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("每个viewID:"+videoIds[i]);
    	}
    	System.out.println("viewID:"+videoIds);
    	for (Integer integer : videoIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=vS.delVideoByvideoIdArrayWithAdmin(videoIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("删除成功"+videoIds.length);
			return "redirect:/VideoControl/videosManage.do";
		}
		System.out.println("-----"+videoIds.length);		
    	return "videosManage";
    }
}
