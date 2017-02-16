package com.osms.dao;

import java.util.List;

import com.osms.entity.Payment;

public interface PaymentDao {

	/**
	 * 通过费用表id获取费用记录
	 * @param paymentId
	 * @return
	 */
	public Payment getPaymentByPaymentId(int paymentId);
	
	/**
	 * 获取所有费用记录
	 * @return
	 */
	public List<Payment> getAllPayment();
	
	/**
	 * 保存一条费用记录
	 * @param payment
	 */
	public void save(Payment payment);
	
	/**
	 * 更细一条费用记录
	 * @param payment
	 */
	public void update(Payment payment);
	
	/**
	 * 删除操作
	 * @param paymentId
	 * 		关键字
	 * @param userId
	 * 		关键字
	 * @param paymentTypeId
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int paymentId, int userId, int paymentTypeId, String type);
}
