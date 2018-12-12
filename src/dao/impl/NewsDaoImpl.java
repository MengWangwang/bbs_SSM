package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.apache.bcel.generic.RET;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import model.News;
import model.User;
import dao.NewsDao;
@Repository("NewsDao")
public class NewsDaoImpl implements NewsDao{
	@Resource(name="sessionFactory")
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession(){
		return factory.getCurrentSession();
	}
	@Override
	public int addNews(News n) {
		Integer res=0;
		res=(Integer) this.getSession().save(n);
		return res;
	}

	@Override
	public int updateNews(News n, String title, String content) {
		News n1=(News) this.getSession().get(News.class, n.getId());
		n1.setTitle(title);
		n1.setContent(content);
		return (Integer) this.getSession().save(n1);
	}

	@Override
	public void deleteNewById(int id) {
		News n1=(News) this.getSession().get(News.class, id);
		
		 this.getSession().delete(n1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByUserid(int Userid) {
		List<News> lst =new ArrayList<News>();
		Session session=getSession();
		Query query=session.createQuery("from News where userid=?");
		query.setParameter(0, Userid);
		lst=query.list();
		return lst;
	}

	@Override
	public List<News> getAllNews(int pageIndex, int pageSize) {
		List<News> lst =new ArrayList<News>();
		Criteria cta=(Criteria) getSession().createCriteria(News.class);
		cta.setFirstResult((pageSize-pageIndex)*pageSize);
		cta.setMaxResults(pageSize);
		lst=cta.list();
		return lst;
	}

	@Override
	public News getNewsById(int id) {
		News n=(News) this.getSession().get(News.class, id);
		return n;
	}

	@Override
	public List<News> getNewsByTitle(String title, int pageIndex, int pageSize) {
		List<News> lst =new ArrayList<News>();
		Criteria cta=(Criteria) getSession().createCriteria(News.class);
		cta.add(Restrictions.like("title", "%"+title+"%"));
		cta.setFirstResult((pageIndex-1)*pageSize);
		cta.setMaxResults(pageSize);
		lst=cta.list();
		return lst;
	}

	@Override
	public Long getCountAllNews() {
		Long res=null;
		Session session=getSession();
		Query query=session.createQuery("select count(*) from News");
		res=(Long) query.uniqueResult();
		return res;
	}

	@Override
	public Long getCountByTitle(String title) {
		Long res=null;
		Criteria cta=(Criteria) getSession().createCriteria(News.class);
		cta.add(Restrictions.like("title", "%"+title+"%"));
		cta.setProjection(Projections.rowCount());
		res=(Long) cta.uniqueResult();
		return res;
	}
}