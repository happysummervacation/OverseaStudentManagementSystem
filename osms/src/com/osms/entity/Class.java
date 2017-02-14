package com.osms.entity;

import java.io.Serializable;
/**
 * 班级信息配置表
 * @author Administrator
 *
 */
public class Class implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int classId;//班级ID
	private String className;//班级名称
	private int majorId;//专业ID
	
	
	/**
	 * 聚合对象
	 */
	private Major major;//专业对象
	
	public Class()
	{
		
	}

	/**
	 * 聚合对象
	 * @param major
	 */
	public Class(Major major) {
		this.major = major;
	}

	/**
	 * 私有变量
	 * @param classId
	 * @param className
	 * @param majorId
	 */
	public Class(int classId, String className, int majorId) {
		this.classId = classId;
		this.className = className;
		this.majorId = majorId;
	}

	/**
	 * 私有变量
	 * 聚合对象
	 * @param classId
	 * @param className
	 * @param majorId
	 * @param major
	 */
	public Class(int classId, String className, int majorId, Major major) {
		this.classId = classId;
		this.className = className;
		this.majorId = majorId;
		this.major = major;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", majorId=" + majorId + ", major=" + major
				+ "]";
	}

	
	
}
