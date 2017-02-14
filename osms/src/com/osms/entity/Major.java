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
	private int academyId;//学院ID
	
	/**
	 * 包含聚合对象
	 */
	private Academy academy;//学院对象
	
	public Major()
	{
		
	}

	/**
	 * 聚合对象
	 * @param academy
	 */
	public Major(Academy academy) {
		this.academy = academy;
	}

	/**
	 * 私有变量
	 * @param majorId
	 * @param majorName
	 * @param academyId
	 */
	public Major(int majorId, String majorName, int academyId) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.academyId = academyId;
	}

	/**
	 * 私有变量
	 * 聚合对象
	 * @param majorId
	 * @param majorName
	 * @param academyId
	 * @param academy
	 */
	public Major(int majorId, String majorName, int academyId, Academy academy) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.academyId = academyId;
		this.academy = academy;
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

	public int getAcademyId() {
		return academyId;
	}

	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	@Override
	public String toString() {
		return "Major [majorId=" + majorId + ", majorName=" + majorName + ", academyId=" + academyId + ", academy="
				+ academy + "]";
	}
	
	
	
	
}
