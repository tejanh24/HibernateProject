package com.teja.hibernate.dao.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {
	
	private static HibernateConnector me;
	
	private SessionFactory factory;
	
	private Configuration cfg;
	
	private ServiceRegistry service;
	
	private HibernateConnector(Configuration config) throws HibernateException {
		
		if(config == null) {
			cfg = new Configuration();
		}else {
			cfg = config;
		}
		
		cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/Hibernate");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password","123456");
		cfg.setProperty("hibernate.connection.pool_size","1");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		
		cfg.addClass(com.teja.hibernate.dao.model.UserModel.class);
		
		ServiceRegistryBuilder srcBuilder = new ServiceRegistryBuilder();
		srcBuilder.applySettings(cfg.getProperties());
		service = srcBuilder.buildServiceRegistry();
		factory = cfg.buildSessionFactory(service);
		
		
	}
	
	public static HibernateConnector getInstance() throws HibernateException {
		if(me == null) {
			me = new HibernateConnector(null);
		}
		return me;
	}
	
	public Session getSession() throws HibernateException {
		Session session = factory.openSession();
		if(!session.isConnected()) {
			this.reconnect();
		}
		return session;
	}
	
	public void reconnect() throws HibernateException {
		this.factory = cfg.buildSessionFactory(service);
	}
	
	public void close() throws HibernateException {
		factory.close();
	}

}
