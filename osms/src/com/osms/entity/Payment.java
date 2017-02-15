package com.osms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建缴费表
 * @author Administrator
 *
 */
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int paymentId=0;//缴费单Id
	private int userId=0;//缴费人Id
	private int paymentTypeId=0;//缴费类型Id
	private double money=0;//金额
	private Date payTime=null;//缴费时间
	private boolean isDone=false;//是否完成本次缴费单
	private String description=null;//描述
	private int status=0;//状态
	
	/**
	 * 聚合对象
	 */
	private Users user=null;//缴费人对象
	private PaymentType paymentType=null;//缴费类型对象
	
	
	public Payment()
	{
		
	}


	/**
	 * 私有变量构造
	 * @param paymentId
	 * @param userId
	 * @param paymentTypeId
	 * @param money
	 * @param payTime
	 * @param isDone
	 * @param description
	 * @param status
	 */
	public Payment(int paymentId, int userId, int paymentTypeId, double money, Date payTime, boolean isDone,
			String description, int status) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.paymentTypeId = paymentTypeId;
		this.money = money;
		this.payTime = payTime;
		this.isDone = isDone;
		this.description = description;
		this.status=status;
	}


	/**
	 * 聚合对象构造
	 * @param user
	 * @param paymentType
	 */
	public Payment(Users user, PaymentType paymentType) {
		this.user = user;
		this.paymentType = paymentType;
	}


	/**
	 * 私有变量
	 * 聚合对象
	 * @param paymentId
	 * @param userId
	 * @param paymentTypeId
	 * @param money
	 * @param payTime
	 * @param isDone
	 * @param description
	 * @param status
	 * @param user
	 * @param paymentType
	 * 
	 */
	public Payment(int paymentId, int userId, int paymentTypeId, double money, Date payTime, boolean isDone,
			String description, int status, Users user, PaymentType paymentType) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.paymentTypeId = paymentTypeId;
		this.money = money;
		this.payTime = payTime;
		this.isDone = isDone;
		this.description = description;
		this.status=status;
		this.user = user;
		this.paymentType = paymentType;
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPaymentTypeId() {
		return paymentTypeId;
	}


	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public Date getPayTime() {
		return payTime;
	}


	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public PaymentType getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", paymentTypeId=" + paymentTypeId
				+ ", money=" + money + ", payTime=" + payTime + ", isDone=" + isDone + ", description=" + description
				+ ", status=" + status + ", user=" + user + ", paymentType=" + paymentType + "]";
	}
	
	
}
