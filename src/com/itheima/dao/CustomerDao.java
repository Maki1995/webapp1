package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerDao {
	
	//保存客户
	void save(Customer customer);
	//查询客户列表
	List<Customer> findAllCustomer();
	//根据ID查询客户信息
	Customer getCustById(Long cust_id);
	//根据条件查询用户的信息
    List<Customer> findAllCustomer(DetachedCriteria dc);
}
