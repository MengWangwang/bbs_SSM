package model;

public class Comments {

	private int id;
	private String content;
	private String title;
	private int newsid;
	private int userid;
	private String time;
	private String userName;
	
	private User user;
	private News news;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", content=" + content + ", title="
				+ title + ", newsid=" + newsid + ", userid=" + userid
				+ ", time=" + time + ", userName=" + userName + ", user="
				+ user + ", news=" + news + "]";
	}
	public Comments(String content, String title, int newsid, int userid,
			String time, String userName, User user, News news) {
		super();
		this.content = content;
		this.title = title;
		this.newsid = newsid;
		this.userid = userid;
		this.time = time;
		this.userName = userName;
		this.user = user;
		this.news = news;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
