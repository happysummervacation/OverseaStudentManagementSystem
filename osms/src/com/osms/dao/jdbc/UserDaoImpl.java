package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.UserDao;
import com.osms.entity.Users;
import com.osms.utils.Packager;

@Repository("userDao")
public class UserDaoImpl extends JDBCBase implements UserDao{
	
	@Override
	public Users getUserByUserId(int userId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Users user=null;
		
		String sql="SELECT * FROM Users WHERE userId="+userId;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				user=Packager.PackagerUser(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return user;
	}

	@Override
	public List<Users> getUsers(int typeId) {
		List<Users> users=new ArrayList<Users>();
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM Users WHERE typeId="+typeId;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				users.add(Packager.PackagerUser(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return users;
	}

	/**
	 * 事务提交
	 * 顺序：护照页表->签证表、(hook)[学期期限表]->学籍表、国外身份表、Users表
	 */
	@Override
	public int save(Users user, Connection conn) {
		String sql="INSERT INTO Users VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] param={
			user.getFullName(),
			user.isGender(),
			user.getTypeId(),
			user.getPhone(),
			user.getEmail(),
			user.getPassword(),
			user.getForeignIdentityId(),
			user.getVisaId(),
			user.getSchoolRollId(),
			user.getStatus()
		};
		//保存user信息
		int userId=save(sql, param, conn);
		return userId;
	}


	@Override
	public void update(Users user) {
		StringBuilder sql= new StringBuilder("UPDATE Users SET foreignIdentityId=?, visaId=?, schoolRollId=?, gender=?, typeId=?, status=?");
		ArrayList<Object> paramList=new ArrayList<Object>();
		paramList.add(user.getForeignIdentityId());
		paramList.add(user.getVisaId());
		paramList.add(user.getSchoolRollId());
		paramList.add(user.isGender());
		paramList.add(user.getTypeId());
		paramList.add(user.getStatus());
		
		if(user.getFullName()!=null)
		{
			sql.append(", fullName=?");
			paramList.add(user.getFullName());
		}
		
		if(user.getPhone()!=null)
		{
			sql.append(", phone=?");
			paramList.add(user.getPhone());
		}
		
		if(user.getEmail()!=null)
		{
			sql.append(", email=?");
			paramList.add(user.getEmail());
		}
		
		if(user.getPassword()!=null)
		{
			sql.append(", password=?");
			paramList.add(user.getPassword());
		}
		
		sql.append(" WHERE userId=?");
		paramList.add(user.getUserId());
		
		Object[] param=paramList.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
	}

}
