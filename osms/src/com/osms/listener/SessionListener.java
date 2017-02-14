package com.osms.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 创建session时监听session，测试时长够长
 * @author Administrator
 *
 */


public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(getTime() + "  创建session" + arg0.getSession().getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println(getTime() + "  销毁session" + arg0.getSession().getId());
	}

	/**
	 * 获取系统时间
	 * @return
	 */
	private String getTime() {
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

}
