package com.teja.hibernate.dao.hibernate;

import com.teja.hibernate.dao.DAOFactory;
import com.teja.hibernate.dao.interfaces.UserBasicDAO;
import com.teja.hibernate.dao.impl.HibernateUserBasicDAO;

public class HibernateDAO extends DAOFactory {
	
	private UserBasicDAO userBasicDAO;
	
	public UserBasicDAO getUserBasicDAO() {
		if(userBasicDAO == null) {
			synchronized(UserBasicDAO.class) {
				if(userBasicDAO == null) {
					userBasicDAO = new HibernateUserBasicDAO();
				}
			}
		}
		return userBasicDAO;
	}

}
