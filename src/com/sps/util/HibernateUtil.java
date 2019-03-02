package com.sps.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 数据库操作工具类
 * 
 */
public class HibernateUtil {

	//测试提交
	
	private static SessionFactory sessionFactory;
	private static Session session;

	@SuppressWarnings("static-access")
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

	// 获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	// 关闭Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
