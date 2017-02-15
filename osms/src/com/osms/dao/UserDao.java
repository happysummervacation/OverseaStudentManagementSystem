package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.Users;

public interface UserDao {

	/**
	 * 通过用户id号查找用户
	 * @param userId
	 * 		user id
	 * @return
	 * 		Users
	 */
	public Users getUserByUserId(int userId);
	
	
	/**
	 * 通过用户类型获取用户对象集合
	 * @param typeId
	 * 		int
	 * @return
	 * 		List<Users>
	 */
	public List<Users> getUsers(int typeId);
	
	
	/**
	 * 事务提交
	 * 保存一个用户对象
	 * @param user
	 * @param conn
	 * @return
	 */
	public int save(Users user, Connection conn);
	
	/**
	 * 更新留学生信息
	 * 仅表Users中的信息在此处更新
	 * @param user
	 */
	public void update(Users user);
}
