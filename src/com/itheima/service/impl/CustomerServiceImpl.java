package com.itheima.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.HibernateUtil;
import org.hibernate.criterion.DetachedCriteria;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao = new CustomerDaoImpl();
	@Override
	//添加客户
	public void save(Customer customer) {
		//获得session对象
		Session session = HibernateUtil.getCurrentSession();
		//开启事务
		Transaction ts = session.beginTransaction();
		//将请求想dao层传递
		try {
			dao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		//提交事务
		ts.commit();
	}
	@Override
	//获取用户列表
	public List<Customer> findAllCustomer() {
		
		//获取session对象
		Session session = HibernateUtil.getCurrentSession();
		//开启事务
		Transaction ts = session.beginTransaction();
		List<Customer> list = null;
		try {
			list = dao.findAllCustomer();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		return list;
	}

    @Override
	//根据条件查询用户信息列表
    public List<Customer> findAllCustomer(DetachedCriteria dc) {

		//开启事务
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		//查询
		List<Customer> list = dao.findAllCustomer(dc);
		return list;
    }

}
