package com.osms.entity;

import java.util.Date;

public class LoginBean {

	// 登录用户的id
	private String loginName;
	// 登录的ip地址
	private String ip;
	// 登录时间
	private Date loginTime;
	
	
	public String getLoginName() {
		return loginName;
	}
	
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	public String getIp() {
		return ip;
	}
	
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	public Date getLoginTime() {
		return loginTime;
	}
	
	
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}
