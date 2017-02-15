package com.osms.dao;

import java.util.List;

import com.osms.entity.Status;

public interface StatusDao {

	/**
	 * 通过状态表Id获取对象
	 * @param statusId
	 */
	public Status getStatusByStatusId(int statusId);
	
	/**
	 * 获取所有状态类型
	 * @return
	 */
	public List<Status> getAllStatus();
	
	/**
	 * 保存一种状态信息
	 * @param status
	 */
	public void save(Status status);
	
	/**
	 * 更新一种状态
	 * @param status
	 */
	public void update(Status status);
	
	/**
	 * 删除操作
	 * @param statusId
	 * 		关键字
	 * @param statusName
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int statusId, String statusName, String type);
}
