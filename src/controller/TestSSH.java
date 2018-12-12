package controller;

import model.User;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ServiceNews;
import service.ServiceUser;

public class TestSSH {
	public static void main(String[] args) {
		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*SessionFactory sf=(SessionFactory) act.getBean("sessionFactory");*/
		ServiceUser su=(ServiceUser) act.getBean("ServiceUser");
		User u=new User();
		System.out.println(su.addUser(u));
	}

}
