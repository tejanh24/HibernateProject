package com.teja.hibernate.test;

import com.teja.hibernate.dao.model.UserModel;
import com.teja.hibernate.dao.interfaces.UserBasicDAO;
import com.teja.hibernate.dao.hibernate.HibernateDAO;
import com.teja.hibernate.dao.DAOFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBasicDAO userBasicDAO = DAOFactory.getInstance().getUserBasicDAO();
		UserModel user = userBasicDAO.findbyID(1);
		if(user != null) {
			System.out.println("ID: " + user.getUserID() + "\nName: " + user.getName());
		}else {
			System.out.println("Not found");
		}

	}

}
