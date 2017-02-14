package com.osms.entity;

import java.io.Serializable;
import java.util.List;

/**
 *护照配置表 
 * @author Administrator
 *
 */
public class Passport implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int passportId;//护照ID
	private String passportNum=null;//护照号
	private String passportPage=null;//护照页图片链接
	//配置list
	private List<String> passportPageList=null;//分割后的护照页链接数组
	
	public Passport()
	{
		
	}
	
	
	public Passport(int passportId, String passportNum, String passportPage) {
		this.passportId = passportId;
		this.passportNum = passportNum;
		this.passportPage = passportPage;
	}

	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getPassportNum() {
		return passportNum;
	}
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	public String getPassportPage() {
		return passportPage;
	}
	public void setPassportPage(String passportPage) {
		this.passportPage = passportPage;
	}
	
	/**
	 * 类表属性成员
	 * @return
	 */
	public List<String> getPassportPageList() {
		return passportPageList;
	}
	
	/**
	 * 非表属性成员
	 * @param passportPageList
	 */
	public void setPassportPageList(List<String> passportPageList) {
		this.passportPageList = passportPageList;
	}



	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", passportNum=" + passportNum + ", passportPage=" + passportPage
				+ "]";
	}
	
	
}
