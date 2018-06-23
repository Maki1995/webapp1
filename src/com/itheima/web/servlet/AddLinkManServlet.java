package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.LinkMan;
import com.itheima.service.LinkManService;
import com.itheima.service.impl.LinkManServiceImpl;

public class AddLinkManServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//封装客户端提交的数据
		LinkMan linkMan = new LinkMan();
		try {
			BeanUtils.populate(linkMan, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//调用LinkManService层保存联系人的方法
		LinkManService service = new LinkManServiceImpl();
		service.save(linkMan);
		
		//重定向至联系人列表页面
		response.sendRedirect(request.getContextPath()+"/showLinkManList");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}