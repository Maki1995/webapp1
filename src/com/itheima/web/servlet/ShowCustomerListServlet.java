package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ShowCustomerListServlet extends HttpServlet {

	private CustomerService service = new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//收集客户端提交的数据
		String cust_name = request.getParameter("cust_name");
		//获取离线criteria,封装查询条件
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断客户端提交的数据不为空
		if (cust_name!=null && !"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		//不为空添加条件
		List<Customer> list = service.findAllCustomer(dc);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}