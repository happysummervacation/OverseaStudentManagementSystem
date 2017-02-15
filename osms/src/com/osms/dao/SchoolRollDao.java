package com.osms.dao;

import java.sql.Connection;

import com.osms.entity.SchoolRoll;

public interface SchoolRollDao {

	/**
	 * 通过学籍信息表Id检索信息
	 * @param schoolRollId
	 * @return
	 */
	public SchoolRoll getSchoolRollByschoolRoolId(int schoolRollId);
	
	
	/**
	 * 事务提交
	 * 保存一个学籍对象
	 * @param schoolRoll
	 * @param conn
	 * @return
	 */
	public int save(SchoolRoll schoolRoll, Connection conn);
	
	
	/**
	 * 更新一条学籍记录信息
	 * @param schoolRoll
	 */
	public void update(SchoolRoll schoolRoll);
	
	
	/**
	 * 删除操作
	 * @param schoolRollId
	 * 		关键字
	 * @param cardNum
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int schoolRollId, String cardNum, String type);
}
