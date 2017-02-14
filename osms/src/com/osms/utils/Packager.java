package com.osms.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.osms.entity.Users;

public class Packager {

	/**
	 * Users数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Users PackagerUser(ResultSet rs) throws SQLException
	{
		Users user=new Users();
		user.setUserId(rs.getInt("userId"));
		user.setFullName(rs.getString("fullName"));
		user.setGender(rs.getBoolean("gender"));
		user.setTypeId(rs.getInt("typeId"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setForeignIdentityId(rs.getInt("foreignIdentityId"));
		user.setVisaId(rs.getInt("visaId"));
		user.setSchoolRollId(rs.getInt("schoolRollId"));
		return user;
	}
}
