package com.osms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 用户过滤器&&请求路径验证
 * 		禁止多机登录
 * 		禁止非法请求
 * @author Administrator
 *
 */
public class UserFilter implements Filter{
	
	protected Logger logger=LoggerFactory.getLogger(getClass());
	
	//需验证的url请求
	private String check=null;
	//错误跳转链接
	private String error_url=null;
	//获取session中用户
	private String userConstant=null;
	
	@Override
	public void destroy() {
		//清空相关资源
		this.check=null;
		this.userConstant=null;
		this.error_url=null;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		
		//检查当前用户是否为登录状态
		if(isUserOnline(request))
		{
			chain.doFilter(request, response);
			return;
		}
		
		//检查url是否需验证
		if(isChecked(request))
		{
			chain.doFilter(request, response);
			return;
		}
		
		//错误跳转链接
		response.sendRedirect(request.getContextPath()+error_url);
		return;
	}
	
	
	/**
	 * 检查是否为需要验证的url
	 * @param request
	 * 		{@link HttpServletRequest}
	 * @param url
	 * 		请求的url
	 * @return
	 * 		Boolean
	 */
	private boolean isChecked(HttpServletRequest request)
	{
		//获取当前的url请求
		String check_url=request.getRequestURI();
		//分割需要验证url请求
		String[] checked=this.check.split(";");
		//匹配
		for(String item:checked)
		{
			//找到匹配的项，返回true
			if((request.getContextPath()+item).equals(check_url))
			{
				logger.info("找到匹配的url项 {}  :"+item);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 检查当前用户是否在线
	 * @param user
	 * 		Object
	 * @return
	 */
	private boolean isUserOnline(HttpServletRequest request)
	{
		//获取session中的用户对象
		Object user=request.getSession().getAttribute(userConstant);
		return null==user?true:false;
	}

	
	@Override
	public void init(FilterConfig config) throws ServletException {
		//获取需验证的url请求
		this.check=config.getInitParameter("check");
		//获取用户
		this.userConstant=config.getInitParameter("user");
		//获取被禁止的请求的咋混发url
		this.error_url=config.getInitParameter("error_url");
		
	}

}
