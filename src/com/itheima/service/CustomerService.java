package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {

	//保存客户
	void save(Customer customer);
	//查询所有客户信息
	List<Customer> findAllCustomer();
	//根据条件查询用户信息
    List<Customer> findAllCustomer(DetachedCriteria dc);
}
