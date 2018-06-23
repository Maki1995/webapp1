package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.service.impl.CustomerServiceImpl;


public class AddCustomerServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取客户端提交的数据，并封装到实体中
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//将请求想service层传递
		CustomerService service = new CustomerServiceImpl();
		service.save(customer);
		
		//重定向至客户列表页面
		response.sendRedirect(request.getContextPath()+"/showCustomerList");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}