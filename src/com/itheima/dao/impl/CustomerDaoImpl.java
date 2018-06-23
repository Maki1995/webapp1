package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	//添加客户信息
	public void save(Customer customer) {
		
		Session session = HibernateUtil.getCurrentSession();
		//保存客户对象
		session.save(customer);
		
	}

	@Override
	//展示客户信息
	public List<Customer> findAllCustomer() {
		
		Session session = HibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		return list;
	}

	@Override
	//根据客户ID查询客户信息
	public Customer getCustById(Long cust_id) {
		
		Session session = HibernateUtil.getCurrentSession();
		return session.get(Customer.class, cust_id);
	}

    @Override
	//根据条件查询用户的信息
    public List<Customer> findAllCustomer(DetachedCriteria dc) {

		Session session = HibernateUtil.getCurrentSession();
		//将离线criteria与session绑定
		Criteria criteria = dc.getExecutableCriteria(session);
		//查询数据
		List<Customer> list = criteria.list();
		return list;
    }

}
