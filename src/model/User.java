package model;

public class User {
   private int id;
   private String account;
   private String name;
   private String eamil;
   private String psw;
   
   public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEamil() {
	return eamil;
}

public void setEamil(String eamil) {
	this.eamil = eamil;
}

public String getPsw() {
	return psw;
}

public void setPsw(String psw) {
	this.psw = psw;
}

public User(String account, String name, String eamil, String psw) {
	super();
	this.account = account;
	this.name = name;
	this.eamil = eamil;
	this.psw = psw;
}
   @Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", name=" + name
			+ ", eamil=" + eamil + ", psw=" + psw + "]";
}

public User() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
