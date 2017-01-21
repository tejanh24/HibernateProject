package com.teja.hibernate.dao.impl;

import com.teja.hibernate.dao.interfaces.UserBasicDAO;
import com.teja.hibernate.dao.model.UserModel;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import com.teja.hibernate.dao.hibernate.HibernateConnector;

import java.util.List;

public class HibernateUserBasicDAO implements UserBasicDAO {
	
	public UserModel findbyID (int id) {
		UserModel user = null;
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			String query = "from UserModel where userID = ?";
			List list = session.createQuery(query).setInteger(0, id).list();
			
			if(list.isEmpty()) { 
				return null;
			}
			
			user = (UserModel) list.get(0);
			
		}catch(HibernateException hex) {
			hex.printStackTrace();
		}finally{
			if(session!=null) {
				try {
					session.close();
				}catch(HibernateException hex) {
					hex.printStackTrace();
				}
			}
		}
		
		return user;
	}
}
