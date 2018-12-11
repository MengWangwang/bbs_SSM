package dao.impl;

import javax.annotation.Resource;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import dao.UserDao;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{
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
	public User getUsersAccountAndPsw(String account, String psw) {
		Session session=getSession();
		Query query=session.createQuery("from User where account=? and psw=?");
		query.setParameter(0, account);
		query.setParameter(1, psw);
		User u=(User) query.uniqueResult();
		return u;
	}

	@Override
	public int addUser(User u) {
		Integer res=0;
		res=(Integer) this.getSession().save(u);
		
		return res;
	}

	@Override
	public void updateUserPsw(int id, String psw) {
		User u=(User) this.getSession().get(User.class, id);
		u.setPsw(psw);
	}

	@Override
	public User getUserByid(int id) {
		User u=(User) this.getSession().get(User.class, id);
		return u;
	}

	@Override
	public User getUserByAccount(String account) {
		Session session=getSession();
		Query query=session.createQuery("from User where account=?");
		query.setParameter(0, account);
		User u=(User) query.uniqueResult();
		return u;
	}

	@Override
	public User getUserbyNewsid(int newsid) {
		Session session=getSession();
		Query query=session.createQuery("from User where newsid=?");
		query.setParameter(0, newsid);
		User u=(User) query.uniqueResult();
		return u;
	}

}
