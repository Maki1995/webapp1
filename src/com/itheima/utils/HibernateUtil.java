package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static{
		//获取配置文件加载对象
		Configuration conf = new Configuration().configure();
		//根据配置文件创建sessionFactory对象
		sf = conf.buildSessionFactory();

	}
	
	//获得全新的session对象

	public static Session openSession(){
		return sf.openSession();
	}
	
	//获得与线程绑定的session对象
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
}
