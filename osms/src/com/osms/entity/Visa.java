package com.osms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 签证表
 * @author Administrator
 *
 */
public class Visa implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int visaId=0;//签证ID
	private String registerDeadline=null;//注册截止时间
	private String intermediary=null;//中介
	private String intermediaryPhone=null;//中介联系电话
	private String guaranteeName=null;//担保人姓名
	private String guaranteePhone=null;//担保人姓名
	private int fundingSourceId=0;//经费来源ID
	private int passportId=0;//护照ID
	private Date approvalTime=null;//审批时间
	private Date visaDueTime=null;//签证到期时间
	
	
	
	//包含配置类
	private Passport passport=null;
	private FundingSource fundingSource=null;
	
	public Visa()
	{
		
	}
	
	public Visa(Passport passport, FundingSource fundingSource)
	{
		this.passport = passport;
		this.fundingSource = fundingSource;
	}
	
	

	public Visa(int visaId, String registerDeadline, String intermediary, String intermediaryPhone,
			String guaranteeName, String guaranteePhone, int fundingSourceId, int passportId, Date approvalTime,
			Date visaDueTime) {
		this.visaId = visaId;
		this.registerDeadline = registerDeadline;
		this.intermediary = intermediary;
		this.intermediaryPhone = intermediaryPhone;
		this.guaranteeName = guaranteeName;
		this.guaranteePhone = guaranteePhone;
		this.fundingSourceId = fundingSourceId;
		this.passportId = passportId;
		this.approvalTime = approvalTime;
		this.visaDueTime = visaDueTime;
	}

	
	public Visa(int visaId, String registerDeadline, String intermediary, String intermediaryPhone,
			String guaranteeName, String guaranteePhone, int fundingSourceId, int passportId, Date approvalTime,
			Date visaDueTime, Passport passport, FundingSource fundingSource) {
		this.visaId = visaId;
		this.registerDeadline = registerDeadline;
		this.intermediary = intermediary;
		this.intermediaryPhone = intermediaryPhone;
		this.guaranteeName = guaranteeName;
		this.guaranteePhone = guaranteePhone;
		this.fundingSourceId = fundingSourceId;
		this.passportId = passportId;
		this.approvalTime = approvalTime;
		this.visaDueTime = visaDueTime;
		this.passport = passport;
		this.fundingSource = fundingSource;
	}

	public int getVisaId() {
		return visaId;
	}
	public void setVisaId(int visaId) {
		this.visaId = visaId;
	}
	public String getRegisterDeadline() {
		return registerDeadline;
	}
	public void setRegisterDeadline(String registerDeadline) {
		this.registerDeadline = registerDeadline;
	}
	public String getIntermediary() {
		return intermediary;
	}
	public void setIntermediary(String intermediary) {
		this.intermediary = intermediary;
	}
	public String getIntermediaryPhone() {
		return intermediaryPhone;
	}
	public void setIntermediaryPhone(String intermediaryPhone) {
		this.intermediaryPhone = intermediaryPhone;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	
	public String getGuaranteePhone() {
		return guaranteePhone;
	}

	public void setGuaranteePhone(String guaranteePhone) {
		this.guaranteePhone = guaranteePhone;
	}

	public int getFundingSourceId() {
		return fundingSourceId;
	}
	public void setFundingSourceId(int fundingSourceId) {
		this.fundingSourceId = fundingSourceId;
	}
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public Date getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}
	public Date getVisaDueTime() {
		return visaDueTime;
	}
	public void setVisaDueTime(Date visaDueTime) {
		this.visaDueTime = visaDueTime;
	}
	
	
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public FundingSource getFundingSource() {
		return fundingSource;
	}

	public void setFundingSource(FundingSource fundingSource) {
		this.fundingSource = fundingSource;
	}

	@Override
	public String toString() {
		return "Visa [visaId=" + visaId + ", registerDeadline=" + registerDeadline + ", intermediary=" + intermediary
				+ ", intermediaryPhone=" + intermediaryPhone + ", guaranteeName=" + guaranteeName + ", fundingSourceId="
				+ fundingSourceId + ", passportId=" + passportId + ", approvalTime=" + approvalTime + ", visaDueTime="
				+ visaDueTime + "]";
	}

	
	
}
