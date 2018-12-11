package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
import service.ServiceUser;
@Service("ServiceUser")
public class ServiceUserImpl implements ServiceUser{
    @Resource(name="UserDao")
    private UserDao ud;
    
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User getUsersAccountAndPsw(String account, String psw) {
		// TODO Auto-generated method stub
		return ud.getUsersAccountAndPsw(account, psw);
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return ud.addUser(u);
		
	}

	@Override
	public void updateUserPsw(int id, String psw) {
		// TODO Auto-generated method stub
		ud.updateUserPsw(id, psw);
	}

	@Override
	public User getUserByid(int id) {
		// TODO Auto-generated method stub
		return ud.getUserByid(id);
	}

	@Override
	public User getUserbyNewsid(int newsid) {
		// TODO Auto-generated method stub
		return ud.getUserbyNewsid(newsid);
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return ud.getUserByAccount(account);
	}
	public static void main(String[] args) {
		ServiceUserImpl sui=new ServiceUserImpl();
		sui.updateUserPsw(1, "123");
	}
}
