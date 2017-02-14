package com.osms.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.osms.globle.Constants;


/**
 * 单机登录监听器,控制同一用户不会多客户端同时在线
 */
public class OnLineListener implements HttpSessionAttributeListener {

	/**
	 * 不同的会话Session中，Servlet中调用setAttribute保存信息
	 * @event session绑定该属性的事件
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {

		// 只处理用户登录时保存的用户在线标识的信息
		if (event.getName().equals(Constants.USER)) {

			// 进行用户添加
//			User user = (User) event.getValue();
//			String userId = user.getId()+"";
			
//			addToApplication(userId, event.getSession());
		}
	}

	/**
	 * 移除Session中已存在的属性时触发
	 * @event session绑定该属性的事件
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();

		// 注销
		if (name.equals(Constants.USER)) {
			// 将该session从map中移
//			User user = (User) event.getValue();
//			String userId = user.getId()+"";
//			Map<String, String> userMap = (Map<String, String>) event.getSession().getServletContext().getAttribute(Constants.ONLINE_USERS);
//			userMap.remove(userId);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void addToApplication(String userId, HttpSession session) {
		// 获取application作用域对象
		ServletContext context = session.getServletContext();
		
		// 如果在线用户列表为空则进行初始化
		if(context.getAttribute(Constants.ONLINE_USERS) == null)
			context.setAttribute(Constants.ONLINE_USERS, new HashMap<String, String>());
		
		// 把（用户id-sessionID）存放到用户表中
		HashMap<String, String> userMap = (HashMap<String, String>) context.getAttribute(Constants.ONLINE_USERS);
		userMap.put(userId, session.getId());
	}
	
}
