package com.teja.hibernate.dao.interfaces;

import com.teja.hibernate.dao.model.UserModel;

public interface UserBasicDAO {
	
	UserModel findbyID(int id) ;

}
