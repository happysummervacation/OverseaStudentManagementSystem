package com.osms.entity;

import java.io.Serializable;
/**
 * 国际信息配置表
 * @author Administrator
 *
 */
public class Nationality implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nationalityId=0;//国籍编号
	private String nationalityChineseName=null;//国籍中文名称
	private String nationalityEnglishName=null;//国家英文名
	
	public Nationality()
	{
		
	}

	public Nationality(int nationalityId, String nationalityChineseName, String nationalityEnglishName) {
		this.nationalityId = nationalityId;
		this.nationalityChineseName = nationalityChineseName;
		this.nationalityEnglishName = nationalityEnglishName;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getNationalityChineseName() {
		return nationalityChineseName;
	}

	public void setNationalityChineseName(String nationalityChineseName) {
		this.nationalityChineseName = nationalityChineseName;
	}

	public String getNationalityEnglishName() {
		return nationalityEnglishName;
	}

	public void setNationalityEnglishName(String nationalityEnglishName) {
		this.nationalityEnglishName = nationalityEnglishName;
	}

	@Override
	public String toString() {
		return "Nationality [nationalityId=" + nationalityId + ", nationalityChineseName=" + nationalityChineseName
				+ ", nationalityEnglishName=" + nationalityEnglishName + "]";
	}
	
	
	
}
