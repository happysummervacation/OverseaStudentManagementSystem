package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.Passport;

public interface PassportDao {

	/**
	 * 通过护照表的id检索护照信息
	 * @param passportId
	 * @return
	 */
	public Passport getPassportByPassportId(int passportId);
	
	/**
	 * 通过护照表的护照编号获取护照信息
	 * @param passportNum
	 * @return
	 */
	public Passport getPassportByPassportNum(String passportNum);
	
	/**
	 * 获取所有护照表的护照信息
	 * @return
	 */
	public List<Passport> getAllPassport();
	
	/**
	 * 事务提交
	 * 保存护照信息
	 * @param passport
	 * @param conn
	 * @return
	 */
	public int save(Passport passport, Connection conn);
	
	/**
	 * 更新护照表信息数据
	 * @param passport
	 */
	public void update(Passport passport);
	
	/**
	 * 删除操作
	 * @param passportId、
	 * 		关键字
	 * @param passportNum
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int passportId, String passportNum, String type);
}
