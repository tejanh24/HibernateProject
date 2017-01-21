package com.teja.hibernate.dao.model;

import java.io.Serializable;

public class UserModel implements Serializable {
	
	private int userID;
	private String userName;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}

}
