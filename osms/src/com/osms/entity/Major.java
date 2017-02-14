package com.osms.entity;

import java.io.Serializable;
/**
 * 专业配置表
 * @author Administrator
 *
 */
public class Major implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int majorId;//专业ID
	private String majorName;//专业名称
	
	public Major()
	{
		
	}
	
	public Major(int majorId, String majorName) {
		this.majorId = majorId;
		this.majorName = majorName;
	}
	
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	@Override
	public String toString() {
		return "Major [majorId=" + majorId + ", majorName=" + majorName + "]";
	}
	
	
}
