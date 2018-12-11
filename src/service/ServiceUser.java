package service;

import model.User;

public interface ServiceUser {
	public User getUsersAccountAndPsw(String account,String psw);
	public int addUser(User u);
	public void updateUserPsw(int id,String psw);  
	public User getUserByid(int id);
	public User getUserByAccount(String account);
	public User getUserbyNewsid(int newsid);
}
