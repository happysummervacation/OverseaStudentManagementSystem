package com.osms.entity;

import java.io.Serializable;
/**
 * 学院信息配置表
 * @author Administrator
 *
 */
public class Academy implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int academyId=0;//学院ID
	private String academyName=null;//学院名称
	
	public Academy()
	{
		
	}
	
	public Academy(int academyId, String academyName) {
		this.academyId = academyId;
		this.academyName = academyName;
	}
	public int getAcademyId() {
		return academyId;
	}
	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}
	public String getAcademyName() {
		return academyName;
	}
	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	@Override
	public String toString() {
		return "Academy [academyId=" + academyId + ", academyName=" + academyName + "]";
	}
	
	
}
