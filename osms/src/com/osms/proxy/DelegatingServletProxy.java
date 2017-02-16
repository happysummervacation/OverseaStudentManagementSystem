package com.osms.proxy;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 代理方式获取Bean
 * @author Administrator
 *
 */
public class DelegatingServletProxy extends GenericServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String targetBean=null;
	private Servlet proxy=null;

	/**
	 * 初始化
	 */
	@Override
	public void init() throws ServletException {
		
		this.targetBean=getServletName();
		getServletBean();
		proxy.init(getServletConfig());
	}
	
	/**
	 * 获取Bean
	 */
	private void getServletBean() {
		WebApplicationContext webApplicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		this.proxy=(Servlet) webApplicationContext.getBean(this.targetBean);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		this.proxy.service(request, response);
		
	}

}
