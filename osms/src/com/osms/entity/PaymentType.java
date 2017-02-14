package com.osms.entity;

import java.io.Serializable;

/**
 * 创建缴费类型配置表
 * @author Administrator
 *
 */
public class PaymentType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int paymentTypeId;//缴费类别ID
	private String paymentTypeName;//缴费类别名称
	
	
	public PaymentType()
	{
		
	}


	public PaymentType(int paymentTypeId, String paymentTypeName) {
		this.paymentTypeId = paymentTypeId;
		this.paymentTypeName = paymentTypeName;
	}


	public int getPaymentTypeId() {
		return paymentTypeId;
	}


	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}


	public String getPaymentTypeName() {
		return paymentTypeName;
	}


	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}


	@Override
	public String toString() {
		return "PaymentType [paymentTypeId=" + paymentTypeId + ", paymentTypeName=" + paymentTypeName + "]";
	}
	
	
}
