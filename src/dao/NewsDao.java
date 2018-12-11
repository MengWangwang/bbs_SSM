package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import model.News;
@Component("NewsDao")
public interface NewsDao {
	public int addNews(News n);
	public int updateNews(News n,String title,String content);
	public void  deleteNewById(int id);
	public List<News> getNewsByUserid(int Userid);
	public List<News> getAllNews(int pageIndex,int pageSize);
	public News getNewsById(int id); 
	public List<News> getNewsByTitle(String title,int pageIndex,int pageSize);
	public Long getCountAllNews();
	public Long getCountByTitle(String title);
}
