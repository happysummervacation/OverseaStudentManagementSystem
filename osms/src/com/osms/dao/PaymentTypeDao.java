package com.osms.dao;

import java.util.List;

import com.osms.entity.PaymentType;

public interface PaymentTypeDao {

	/**
	 * 通过费用类型配置表id获取款项类型
	 * @param paymentTypeId
	 * @return
	 */
	public PaymentType getPaymentTypeByPaymentTypeId(int paymentTypeId);
	
	/**
	 * 获取所有费用类型
	 * @return
	 */
	public List<PaymentType> getAllPaymentType();
	
	/**
	 * 保存一种费用类型
	 * @param paymentType
	 */
	public void save(PaymentType paymentType);
	
	/**
	 * 更新一种费用类型
	 * @param paymentType
	 */
	public void update(PaymentType paymentType);
	
	/**
	 * 删除操作
	 * @param paymentTypeId
	 * 		关键字
	 * @param paymentTypeName
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int paymentTypeId, String paymentTypeName, String type);
}
