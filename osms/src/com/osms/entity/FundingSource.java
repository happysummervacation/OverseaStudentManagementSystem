package com.osms.entity;

import java.io.Serializable;
/**
 * 经费来源配置表
 * @author Administrator
 *
 */
public class FundingSource implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int fundingSourceId;//经费来源ID
	private String fundingSourceName;//经费来源地名称
	

	public FundingSource()
	{
		
	}


	
	public FundingSource(int fundingSourceId, String fundingSourceName) {
		this.fundingSourceId = fundingSourceId;
		this.fundingSourceName = fundingSourceName;
	}



	public int getFundingSourceId() {
		return fundingSourceId;
	}


	public void setFundingSourceId(int fundingSourceId) {
		this.fundingSourceId = fundingSourceId;
	}


	public String getFundingSourceName() {
		return fundingSourceName;
	}


	public void setFundingSourceName(String fundingSourceName) {
		this.fundingSourceName = fundingSourceName;
	}



	@Override
	public String toString() {
		return "FundingSource [fundingSourceId=" + fundingSourceId + ", fundingSourceName=" + fundingSourceName + "]";
	}
	

	
}
