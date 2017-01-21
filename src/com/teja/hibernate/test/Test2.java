package com.teja.hibernate.test;

import com.teja.hibernate.dao.hibernate.HibernateDAO;
import com.teja.hibernate.dao.interfaces.UserBasicDAO;
import com.teja.hibernate.dao.model.UserModel;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			UserBasicDAO userDAO = HibernateDAO.getInstance().getUserBasicDAO();
			UserModel user = userDAO.findbyID(2);
			
			if(user != null)
				System.out.println("Sorry");
			else{
				System.out.println("Name " + user.getName());
			}
	}

}
