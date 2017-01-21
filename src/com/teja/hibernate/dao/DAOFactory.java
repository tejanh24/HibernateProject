package com.teja.hibernate.dao;

import com.teja.hibernate.dao.hibernate.HibernateDAO;
import com.teja.hibernate.dao.interfaces.UserBasicDAO;

public abstract class DAOFactory {
	
	private static DAOFactory me ;
	
	protected DAOFactory() {
		
	}
	
	public static DAOFactory getInstance() {
		if(me == null ) {
			synchronized(HibernateDAO.class) {
				if(me == null) {
					me = new HibernateDAO();
				}
			}
		}
		return me;
	}
	
	public abstract UserBasicDAO getUserBasicDAO();

}
