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
	 * ������Ӱ
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
    	//����ҳ������
		int pageSize=10;
		//��ǰҳ��
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/movie.do";
					//response.sendRedirect("movie.do");
			}
		}
		//����������
		int totalCount=vS.getmovieCount(country, type, ageTime);
		//��ҳ��
		Pages<Video> pages=new Pages<Video>();
	
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount();
		//������ҳ��βҳ
		if (currentPageNo<1) {
			currentPageNo=1;
		}else if (currentPageNo>totalPageCount) {
			currentPageNo=totalPageCount;
		}
		movieList=vS.getmovieByType(country, type, ageTime, currentPageNo, pageSize);
		if (movieList==null) {
			throw new VideoException("�����͵ĵ�Ӱ�����ڣ�");
		}
		for (Video video : movieList) {
			System.out.println("��Ƶ���ƣ�"+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("movieList", movieList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "movie";
    }
    
    /**
	 * ��������
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
    	//����ҳ������
		int pageSize=10;
		//��ǰҳ��
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/variety.do";
					//response.sendRedirect("movie.do");
			}
		}
		//����������
		int totalCount=vS.getvarietyCount(country, type, ageTime);
		//��ҳ��
		Pages<Video> pages=new Pages<Video>();
	
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount();
		//������ҳ��βҳ
		if (currentPageNo<1) {
			currentPageNo=1;
		}else if (currentPageNo>totalPageCount) {
			currentPageNo=totalPageCount;
		}
		varietyList=vS.getvarietyByType(country, type, ageTime, currentPageNo, pageSize);
		if (varietyList==null) {
			throw new VideoException("�����͵����ղ����ڣ�");
		}
		for (Video video : varietyList) {
			System.out.println("��Ƶ���ƣ�"+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("varietyList", varietyList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "variety";
    }
    
    /**
	 * �������Ӿ�
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
    	//����ҳ������
		int pageSize=10;
		//��ǰҳ��
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/series.do";
					//response.sendRedirect("movie.do");
			}
		}
		//����������
		int totalCount=vS.gettvCount(country, type, ageTime);
		//��ҳ��
		Pages<Video> pages=new Pages<Video>();
	
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount();
		//������ҳ��βҳ
		if (currentPageNo<1) {
			currentPageNo=1;
		}else if (currentPageNo>totalPageCount) {
			currentPageNo=totalPageCount;
		}
		tvList=vS.getmovieByType(country, type, ageTime, currentPageNo, pageSize);
		if (tvList==null) {
			throw new VideoException("�����͵ĵ��Ӿ粻���ڣ�");
		}
		for (Video video : tvList) {
			System.out.println("��Ƶ���ƣ�"+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("tvList", tvList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "series";
    }
    
    /**
	 * ��������
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
    	//����ҳ������
		int pageSize=10;
		//��ǰҳ��
		int currentPageNo=1;
		if (pageIndex!=null) {
			try {
				currentPageNo=Integer.parseInt(pageIndex); 
			} catch (NumberFormatException  e) {
				  return "redirect:/VideoControl/comic.do";
					//response.sendRedirect("movie.do");
			}
		}
		//����������
		int totalCount=vS.getcomicCount(country, type, ageTime);
		//��ҳ��
		Pages<Video> pages=new Pages<Video>();
	
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount=pages.getTotalPageCount();
		//������ҳ��βҳ
		if (currentPageNo<1) {
			currentPageNo=1;
		}else if (currentPageNo>totalPageCount) {
			currentPageNo=totalPageCount;
		}
		comicList=vS.getcomicByType(country, type, ageTime, currentPageNo, pageSize);
		if (comicList==null) {
			throw new VideoException("�����͵Ķ��������ڣ�");
		}

		for (Video video : comicList) {
			System.out.println("��Ƶ���ƣ�"+video.getVideo_Name()+video.getVideo_KeyWords());
		}
		model.addAttribute("comicList", comicList);		
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPageCount", totalPageCount);		
        return "comic";
    }
    /**
	 * ������ҳ��Ƶ
	 * @return ��ҳ��Ƶ����
	 */
    @RequestMapping(value="/index.do")
	public String getmovieList(Model model) throws Exception{
		List<Video> mIndexList1=null;
		List<Video> mIndexList2=null;
		List<Video> mIndexList3=null;
		List<Video> mIndexList4=null;
		List<Video> mIndexList5=null;
		
		// �����ֻ�ȡ12����Ӱ�ŵ���ҳ	 
		mIndexList1=vS.getMovieByPoints();	
		// ���ȵ��ȡ12����Ӱ�ŵ���ҳ		
		mIndexList2=vS.getMovieByHotPoints();	
		// ��ʱ���ȡ12����Ӱ�ŵ���ҳ	 
		mIndexList3=vS.getMovieByTime();	
		// �����ȡ5����Ӱ�ŵ���ҳ�ֲ���
		mIndexList4=vS.getMovieRandom();
		// �����ȡ9����Ӱ�ŵ���ҳ
		mIndexList5=vS.getMovieRandom2();
		if (mIndexList1==null) {
			throw new VideoException("���޸�����Ƶ��");			
		}				
		if (mIndexList2==null) {
			throw new VideoException("���޸�����Ƶ��");			
		}
		if (mIndexList3==null) {
			throw new VideoException("���޸�����Ƶ��");			
		}	
		if (mIndexList4==null) {
			throw new VideoException("���޸�����Ƶ��");			
		}
		if (mIndexList5==null) {
			throw new VideoException("���޸�����Ƶ��");					
		}
		for (Video video1 : mIndexList1) {
			System.out.println("��Ƶ�����ǣ�"+video1.getVideo_Name());
		}
		for (Video video2 : mIndexList2) {
			System.out.println("��Ƶ�����ǣ�"+video2.getVideo_Name());
		}
		for (Video video3 : mIndexList3) {
			System.out.println("��Ƶ�����ǣ�"+video3.getVideo_Name());
		}	
		for (Video video4: mIndexList4) {
			System.out.println("��Ƶ���ƣ�"+video4.getVideo_Name());
		}
		for (Video video5: mIndexList5) {
			System.out.println("��Ƶ���ƣ�"+video5.getVideo_Name());
		}
		model.addAttribute("mIndexList1", mIndexList1);	
		model.addAttribute("mIndexList2", mIndexList2);
		model.addAttribute("mIndexList3", mIndexList3);
		model.addAttribute("mIndexList4", mIndexList4);
		model.addAttribute("mIndexList5", mIndexList5);
		return "index";
	}
//    /**
//	 * ������ҳ��Ƶ
//	 * @return ��ҳ�����ֲ�ѯ��Ƶ����
//	 */
//    @RequestMapping(value="/PointMovie.do")
//	public String getindexMovieList(Model model) throws Exception{
//		List<Video> mIndexList1=null;		
//		// �����ֻ�ȡ12����Ӱ�ŵ���ҳ	 
//		mIndexList1=vS.getMovieByPoints();	
//		if (mIndexList1==null) {
//			throw new VideoException("���޸�����Ƶ��");			
//		}		
//		for (Video video1 : mIndexList1) {
//			System.out.println("��Ƶ�����ǣ�"+video1.getVideo_Name());
//		}		
//		model.addAttribute("mIndexList1", mIndexList1);		
//		return "index";
//	}
//    /**
//	 * ������ҳ��Ƶ
//	 * @return ��ҳ��ʱ���ѯ��Ƶ����
//	 */
//    @RequestMapping(value="/TimeMovie.do")
//	public String getTimeMovieList(Model model) throws Exception{
//		List<Video> mIndexList3=null;		
//		// �����ֻ�ȡ12����Ӱ�ŵ���ҳ	 
//		mIndexList3=vS.getMovieByPoints();	
//		if (mIndexList3==null) {
//			throw new VideoException("���޸�����Ƶ��");			
//		}		
//		for (Video video3 : mIndexList3) {
//			System.out.println("��Ƶ�����ǣ�"+video3.getVideo_Name());
//		}		
//		model.addAttribute("mIndexList3", mIndexList3);		
//		return "index";
//	}
    @RequestMapping(value="/movieDetail.do")
    public String getMovieDetail(Model model,HttpServletRequest request) throws Exception{    	
    	int videoId=Integer.parseInt(request.getParameter("video_Id"));
    	System.out.println("��Ƶid"+videoId);
    	log.debug("videoId:"+videoId);
    	Video vDetail=new Video();    	
    	vDetail=vS.findDetailByVideoId(videoId);    	
    	if (vDetail.getActorList().size()==0) {
    		System.out.println("----!"); 
    		log.debug("----");    		
			throw new VideoException("��Դ����");			
		}
        System.out.println("��Ա����:"+vDetail.getActorList().size());		
    	System.out.println("��Ƶid:"+vDetail.getVideo_Id());
//    	if (mDetail!=null) {
//    		log.debug("��Ա����id��:"+mDetail.getActorId());
//    		System.out.println("��Ƶ����id:"+mDetail.getVideoId());
//		}    	
    	System.out.println("��Ƶ����id:"+vDetail.getVideo_Id()); 		
    	model.addAttribute("vDetail",vDetail);
    	model.addAttribute("mDetail",vDetail.getActorList());    	
    	return "movieDetail";
    }
    /**
     * ����������Ƶ��ҳ
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
    	//��ҳ��ȡ��Ƶ������ҳ��
    	videoAdminPageList=vS.selectVideoWithAdmin(pageNow);
    	//��ȡҳ����Ϣ
    	page=videoAdminPageList.getPage();
    	//ǿ������ת��    	
		@SuppressWarnings("unchecked")
		List<Video> videoAdminList=(List<Video>) videoAdminPageList.getList();
		if (videoAdminList==null) {
			 log.debug("������Ƶ");
	    	 throw new VideoException("��Ƶ�����ڣ�");
		}
		for (Video video : videoAdminList) {
			log.debug("��Ƶ����:"+video.getVideo_Name());
			log.info("��Ƶ��ӳʱ���ǣ�"+video.getVideo_PictureAddress());
		}
		model.addAttribute("page",page);
    	model.addAttribute("videoAdminList",videoAdminList);
    	return "videosManage";
    }
	//���������Ƶ����ɾ��
    @RequestMapping(value="/videoAdminDelete.do")
    public String delViewsWithAdmin(Model model,HttpServletRequest request) throws Exception{
    	String[] ids = request.getParameterValues("videoIds");
    	for (String string : ids) {
			System.out.println(string);
		}
    	String str=String.join(",",ids);// (Java8) ʹ��join���������ַ���
    	String[] str2=str.split(",");//����,�������
    	System.out.println("str:"+str.length());
    	Integer[] videoIds=new Integer[str2.length];
    	System.out.println("str2:"+videoIds.length);
    	if (videoIds.length<=0) {
			throw new VideoException("ɾ��ʧ��");
		}
    	for(int i=0;i<str2.length;i++){
    		videoIds[i]= Integer.parseInt(str2[i]);  
    		System.out.println("ÿ��viewID:"+videoIds[i]);
    	}
    	System.out.println("viewID:"+videoIds);
    	for (Integer integer : videoIds) {
			System.out.println("integer:"+integer);
		}
    	int count=0;    	
    	count=vS.delVideoByvideoIdArrayWithAdmin(videoIds);
    	System.out.println("count:"+count);
		if (count>0) {
			log.debug("ɾ���ɹ�"+videoIds.length);
			return "redirect:/VideoControl/videosManage.do";
		}
		System.out.println("-----"+videoIds.length);		
    	return "videosManage";
    }
}
