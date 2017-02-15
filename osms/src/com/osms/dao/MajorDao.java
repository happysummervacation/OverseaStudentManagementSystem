package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.Major;

public interface MajorDao {

	/**
	 * 通过专业ID检索专业名称
	 * @param majorId
	 * @return
	 */
	public Major getMajorByMajorId(int majorId);
	
	/**
	 * 获取所有专业信息
	 * @return
	 */
	public List<Major> getAllMajor();
	
	/**
	 * 保存一个专业名称
	 */
	public int save(Major major, Connection conn);
	
	
	/**
	 * 更新专业信息
	 * @param major
	 */
	public void update(Major major);
	
	/**
	 * 删除操作
	 * @param majorId
	 * 		关键字
	 * @param majorName
	 * 		关键字
	 * @param type
	 * 		关键字操作类型，并操作Or或操作
	 */
	public void delete(int majorId, String majorName, String type);
}
