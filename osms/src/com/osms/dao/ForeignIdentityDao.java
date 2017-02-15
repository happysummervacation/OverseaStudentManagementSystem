package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.ForeignIdentity;

public interface ForeignIdentityDao {

	/**
	 * 通过国外信息身份表id查找表数据
	 * @param foreignIdentityId
	 * @return
	 */
	public ForeignIdentity getForeignIdentityByForeignIdentityId(int foreignIdentityId);
	
	
	/**
	 * 获取所有哦国外身份数据
	 * @return
	 */
	public List<ForeignIdentity> getAllForeignIdeneity();
	
	
	/**
	 * 事务提交
	 * 保存一条国外身份数据
	 * @param foreignIdentity
	 * @param conn
	 * @return
	 */
	public int save(ForeignIdentity foreignIdentity, Connection conn);
	
	
	/**
	 * 更新操作
	 * @param foreignIdentity
	 */
	public void update(ForeignIdentity foreignIdentity);
	
	
	/**
	 * 删除操作
	 * @param foreignIdeneityId
	 * 		关键字
	 * @param phone
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int foreignIdeneityId, String phone, String type);
}
