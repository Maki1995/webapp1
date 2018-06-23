package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.LinkManDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.dao.impl.LinkManDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.service.LinkManService;
import com.itheima.utils.HibernateUtil;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd = new CustomerDaoImpl();
	private LinkManDao lm = new LinkManDaoImpl();

	@Override
	//保存联系人
	public void save(LinkMan linkMan) {
		
		//开启事务
		HibernateUtil.getCurrentSession().beginTransaction();
		try {
			//根据客户id获取客户对象
			Long cust_id = linkMan.getCust_id();
			Customer c = cd.getCustById(cust_id);
			//将客户对象放入联系人对象中，表达关系
			linkMan.setCustomer(c);
			//调用LinkManDao保存联系人
			lm .save(linkMan);
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			HibernateUtil.getCurrentSession().getTransaction().rollback();
		}
		//提交事务
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

}
