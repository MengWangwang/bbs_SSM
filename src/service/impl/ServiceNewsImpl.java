package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.NewsDao;
import model.News;
import service.ServiceNews;

@Service("ServiceNews")
public class ServiceNewsImpl implements ServiceNews{
	@Resource(name="NewsDao")
	private NewsDao nd;
	
	public NewsDao getNd() {
		return nd;
	}

	public void setNd(NewsDao nd) {
		this.nd = nd;
	}

	@Override
	public int addNews(News n) {
		// TODO Auto-generated method stub
		return nd.addNews(n);
	}

	@Override
	public int updateNews(News n,String title,String content) {

       
		return nd.updateNews(n, title, content);
	}

	@Override
	public void deleteNewById(int id) {
		
		 nd.deleteNewById(id);
	}

	@Override
	public List<News> getNewsByUserid(int Userid) {
		// TODO Auto-generated method stub
		return nd.getNewsByUserid(Userid);
	}

	@Override
	public List<News> getAllNews(int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		return nd.getAllNews(pageIndex,pageSize);
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return nd.getNewsById(id);
	}

	@Override
	public List<News> getNewsByTitle(String title,int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		return nd.getNewsByTitle(title,pageIndex,pageSize);
	}
	
	@Override
	public Long getCountAllNews() {
		// TODO Auto-generated method stub
		return nd.getCountAllNews();
	}
	
	@Override
	public Long getCountByTitle(String title) {
		// TODO Auto-generated method stub
		return nd.getCountByTitle(title);
	}


	
	public static void main(String[] args) {
		
		ServiceNewsImpl sn=new ServiceNewsImpl();
        News n=sn.getNewsById(1);
       /* News news=new News("123","qwe","2015/5/3",3);*/
       /* sn.addNews(news);*/
       System.out.println(n.getId());
       System.out.println(n.getTitle());
       System.out.println(n.getTime());
       System.out.println(n.getUserid());
       System.out.println(n.getContent());
	}

	
	

}
