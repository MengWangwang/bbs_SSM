package model;

import java.util.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private Date time;
	private int userid;
	private String userName;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", time=" + time + ", userid=" + userid + ", userName="
				+ userName + ", user=" + user + "]";
	}

	public News(String title, String content, Date time, int userid,
			String userName, User user) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
		this.userid = userid;
		this.userName = userName;
		this.user = user;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
