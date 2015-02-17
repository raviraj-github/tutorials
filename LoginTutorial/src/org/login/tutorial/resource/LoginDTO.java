package org.login.tutorial.resource;

public class LoginDTO {
	
	String userName;
	String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", passWord=" + passWord
				+ "]";
	}

}
