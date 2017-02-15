package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.UserTypeDao;
import com.osms.entity.UserType;
import com.osms.utils.Packager;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends JDBCBase implements UserTypeDao {

	@Override
	public UserType getUserTypeByTypeId(int typeId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserType userType=null;
		String sql="SELECT * FROM UserType WHERE typeId="+typeId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				userType=Packager.PackagerUserType(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return userType;
	}

	@Override
	public List<UserType> getAllUserType() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<UserType> userTypes=new ArrayList<UserType>();
		String sql="SELECT * FROM UserType";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				userTypes.add(Packager.PackagerUserType(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return userTypes;
	}

	@Override
	public void save(UserType userType) {
		String sql="INSERT INTO UserType VALUES(?)";
		Object[] param={
			userType.getTypeName()	
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(UserType userType) {
		String sql="UPDATE UserType SET typeName=? WHERE typeId=?";
		Object[] param={
			userType.getTypeName(),
			userType.getTypeId()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(int typeId, String typeName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM UserType WHERE 1=1 ");
		try
		{
			if(typeId!=0)
			{
				sql.append(type+"typeId="+typeId+" ");
			}
			
			if(typeName!=null||!"".equals(typeName))
			{
				sql.append(type+" typeName="+typeName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
