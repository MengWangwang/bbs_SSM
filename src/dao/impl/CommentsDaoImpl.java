package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import model.Comments;
import model.News;
import dao.CommentsDao;

@Repository("CommentsDao")
public class CommentsDaoImpl implements CommentsDao{
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
	public int addComments(Comments c) {
		Integer res=0;
		res=(Integer) this.getSession().save(c);
		return res;
	}

	@Override
	public void deleteComments(int newsid) {
		Comments c=new Comments();
		c.setNewsid(newsid);
		this.getSession().delete(c);
	}

	@Override
	public List<Comments> getCommentsByNewsid(int newsid) {
		Query query=getSession().createQuery("from Comments where newsid=?");
		query.setParameter(0, newsid);
		List<Comments> list= (List<Comments>) query.list();
		
		return list;
	}
	
}
