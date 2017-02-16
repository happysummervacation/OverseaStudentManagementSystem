package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.Visa;

public interface VisaDao {

	/**
	 * 通过签证id获取签证信息
	 * @param visaId
	 * @return
	 */
	public Visa getVisaByVisaId(int visaId);
	
	/**
	 * 获取所有签证信息
	 * @return
	 */
	public List<Visa> getAllVisa();
	
	/**
	 * 事务提交
	 * 保存一条签证记录
	 * @param visa
	 * @param conn
	 * @return
	 */
	public int save(Visa visa, Connection conn);
	
	/**
	 * 更新签证信息
	 * @param visa
	 */
	public void update(Visa visa);
	
	/**
	 * 删除操作
	 * @param visaId
	 * 		关键字
	 * @param passportId
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int visaId, int passportId, String type);
}
