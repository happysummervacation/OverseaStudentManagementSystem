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
	
	private int classId=0;//班级ID
	private String className=null;//班级名称
	
	public Class()
	{
		
	}

	public Class(int classId, String className) {
		this.classId = classId;
		this.className = className;
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

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + "]";
	}
	
}

