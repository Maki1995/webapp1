package com.itheima.dao.impl;

import org.hibernate.Session;

import com.itheima.dao.LinkManDao;
import com.itheima.domain.LinkMan;
import com.itheima.utils.HibernateUtil;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	//保存联系人
	public void save(LinkMan linkMan) {
		
		Session session = HibernateUtil.getCurrentSession();
		session.save(linkMan);
	}

}
