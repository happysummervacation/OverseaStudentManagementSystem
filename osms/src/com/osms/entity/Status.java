package com.osms.entity;

import java.io.Serializable;
/**
 * ÔÚĞ£×´Ì¬ÅäÖÃ±í
 * @author Administrator
 *
 */
public class Status implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int statusId=0;//×´Ì¬ID
	private String statusName=null;//×´Ì¬Ãû³Æ
	
	public Status()
	{
		
	}
	
	public Status(int statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	
}
