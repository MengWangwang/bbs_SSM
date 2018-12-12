package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comments;
import model.News;
import model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import service.ServiceComments;
import service.ServiceNews;
import service.ServiceUser;

@Controller
public class indexController {
	private int pageSize=3;
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	ServiceNews sn=(ServiceNews) act.getBean("ServiceNews");
	ServiceUser su=(ServiceUser) act.getBean("ServiceUser");
	ServiceComments sc=(ServiceComments) act.getBean("ServiceComments");
	
	@RequestMapping(value="index.do",method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		
		Long count=sn.getCountAllNews();
		int num=(int) ((count%pageSize==0)?(count/pageSize):(count/pageSize+1));
		List<News> lst=sn.getAllNews(1, pageSize);
		System.out.println(num);
		System.out.println(lst+"111111111111111");
		request.setAttribute("LstNews", lst);
		request.setAttribute("PageIndex", 1);
		request.setAttribute("PageCount", num);
		return "index";
	}
	
	@RequestMapping(value="index.do",method=RequestMethod.POST)
	public String index1(HttpServletRequest request, HttpServletResponse response){
		String pageIndexStr=request.getParameter("pageIndex");
		String pageCountStr=request.getParameter("pageCount");
		String title=request.getParameter("title");
		System.out.println(title);
		if(title==null || title.trim().equals("")){
			Long count=sn.getCountAllNews();
			int num=(int) ((count%pageSize==0)?(count/pageSize):(count/pageSize+1));
			List<News> lst=sn.getAllNews(Integer.parseInt(pageIndexStr),pageSize);
			System.out.println(lst);
			request.setAttribute("LstNews", lst);
			request.setAttribute("PageIndex", pageIndexStr);
			request.setAttribute("PageCount", num);
		}else{
			Long count=sn.getCountByTitle(title);
			int num=(int) ((count%pageSize==0)?(count/pageSize):(count/pageSize+1));
			List<News> lst=sn.getNewsByTitle(title,Integer.parseInt(pageIndexStr),pageSize);
			System.out.println(lst);
			if(count == 0){
				request.setAttribute("PageIndex", 1);
				request.setAttribute("PageCount", 1);
			}else{
				request.setAttribute("PageIndex", pageIndexStr);
				request.setAttribute("PageCount", num);
			}
			
			request.setAttribute("LstNews", lst);
			request.setAttribute("resTitle",title);
		}
		return "index";
	}
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		String newsid=request.getParameter("newsid");
		request.setAttribute("newsid",newsid);
	    return "login";
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login1(HttpServletRequest request, HttpServletResponse response){
		String newsid=request.getParameter("newsid");
		
		String account=request.getParameter("account");
		String psw=request.getParameter("psw");
		String auto=request.getParameter("auto");
		
		User u= su.getUsersAccountAndPsw(account,psw);
		if(u!=null){
			HttpSession session=request.getSession();
				session.setAttribute("User", u);
				if(auto !=null && auto.equals("1")){
					Cookie cook=new Cookie(account, psw);
					cook.setMaxAge(60*60*24);
					response.addCookie(cook);
				}
				if(newsid.equals("null") || newsid==null || newsid.equals("")){
					return "redirect:index.do";
				}else{
					return "redirect:view.do?newsid="+newsid;
				}
	    }else{
	    	
	    	return "redirect:login.do";
	    }
	}
	
	@RequestMapping(value="zhu.do",method=RequestMethod.GET)
	public String zhu(){
		
		return "zhu";
	}
	
	@RequestMapping(value="zhu.do",method=RequestMethod.POST)
	public String zhu1(User u){
		System.out.println(u);
		if(su.addUser(u)==1){
			return "redirect:login.do";
	    }else{
	    	return "zhu";
	    }	
	}
	
	@RequestMapping(value="lookAccount.do",method=RequestMethod.GET)
	public String lookAccount(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("User");
	    int Userid=user.getId();
		
		List<News> lst=sn.getNewsByUserid(Userid);
		request.setAttribute("LstNews", lst);
		return "lookAccount";
	}
	
	@RequestMapping(value="addNew.do",method=RequestMethod.GET)
	public String addNew(){
		
		return "addNew";
	}
	
	@RequestMapping(value="addNew.do",method=RequestMethod.POST)
	public String addNew1(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("User");
	    int Userid=user.getId();
	    String userName=user.getName();
	    
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Date date=new Date();
	
		News n=new News(title,content,date,Userid,userName, user);
		
		sn.addNews(n);
		
		return "redirect:lookAccount.do";
	}
	
	@RequestMapping(value="changerPsw.do",method=RequestMethod.GET)
	public String changerPsw(){
		
		return "changerPsw";
	}
	
	@RequestMapping(value="changerPsw.do",method=RequestMethod.POST)
	public String changerPsw1(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("User");
	    int Userid=user.getId();
		String newPsw=request.getParameter("newPsw");
		su.updateUserPsw(Userid,newPsw);
		return "redirect:login.do";
	}
	
	@RequestMapping(value="updateNews.do",method=RequestMethod.GET)
	public String updateNews(HttpServletRequest request){
		
		String newsid_str=request.getParameter("newsid");
		News news=sn.getNewsById(Integer.parseInt(newsid_str));
		
		request.setAttribute("News", news);
		return "updateNews";
	}
	
	@RequestMapping(value="updateNews.do",method=RequestMethod.POST)
	public String updateNews1(News n,HttpServletRequest request){
		
		String newsid=request.getParameter("newsid");
		n.setId(Integer.parseInt(newsid));
		sn.updateNews(n,n.getTitle(),n.getContent());
		return "redirect:lookAccount.do";
	}
	
	@RequestMapping(value="deleteNews.do",method=RequestMethod.GET)
	public String deleteNews(HttpServletRequest request){
		String newsid = request.getParameter("newsid");
		
		
		sc.deleteComments(Integer.parseInt(newsid));
		sn.deleteNewById(Integer.parseInt(newsid));
		
		return "redirect:lookAccount.do";
	}
	
	@RequestMapping(value="logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session,HttpServletRequest request){
		
		    session=request.getSession();
		   session.removeAttribute("User");
		  
		   return "redirect:index.do";
	}
	
	@RequestMapping(value="view.do",method=RequestMethod.GET)
	public String view(HttpServletRequest request){
		String newsid_str=request.getParameter("newsid");
		News news=sn.getNewsById(Integer.parseInt(newsid_str));
		request.setAttribute("News", news);
		return "view";
	}
	
	@RequestMapping(value="view.do",method=RequestMethod.POST)
	public String view2(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("User");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
	  	Date date=new Date();
	  	String time=sdf.format(date);
		String newid_str = request.getParameter("newsid"); 
		if(u!=null){
		String content = request.getParameter("content");
		
		String userName=u.getName();
		Comments comm=new Comments();
		comm.setContent(content);
		comm.setTime(time);
		comm.setNewsid(Integer.parseInt(newid_str));
		comm.setUserid(u.getId());
		comm.setUserName(userName);
		sc.addComments(comm);
		
		 return "redirect:view.do?newsid="+newid_str;
		}else{
			return "redirect:login.do?newsid="+newid_str;
		}
	}
	
	@RequestMapping(value="seecomments.do",method=RequestMethod.GET)
	public void seecomments(HttpServletResponse response,HttpServletRequest request) throws IOException{
		String newidStr=request.getParameter("newid");
		List<Comments> lst=sc.getCommentsByNewsid(Integer.parseInt(newidStr));
		Gson g=new Gson();
		java.lang.reflect.Type type=new TypeToken<List<Comments>>(){}.getType();
		String str=g.toJson(lst,type);
		PrintWriter pw=response.getWriter();
		pw.print(str);
		pw.close();
	}

}
