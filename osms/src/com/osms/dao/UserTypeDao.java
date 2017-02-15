package com.osms.dao;

import java.util.List;

import com.osms.entity.UserType;

public interface UserTypeDao {

	/**
	 * 通过用户类型配置表id检索数据
	 * @param typeId
	 * @return
	 */
	public UserType getUserTypeByTypeId(int typeId);
	
	/**
	 * 获取所有用户类型
	 * @return
	 */
	public List<UserType> getAllUserType();
	
	/**
	 * 保存一种用户类型
	 * @param userType
	 */
	public void save(UserType userType);
	
	/**
	 * 更新一种用户类型
	 * @param userType
	 */
	public void update(UserType userType);
	
	/**
	 * 删除操作
	 * @param typeId
	 * 		关键字
	 * @param typeName
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int typeId, String typeName, String type);
}
