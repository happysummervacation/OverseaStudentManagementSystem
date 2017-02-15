package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.ForeignIdentityDao;
import com.osms.entity.ForeignIdentity;
import com.osms.utils.Packager;

@Repository("foreignIdentityDao")
public class ForeignIdentityDaoImpl extends JDBCBase implements ForeignIdentityDao {

	@Override
	public ForeignIdentity getForeignIdentityByForeignIdentityId(int foreignIdentityId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ForeignIdentity foreignIdentity=null;
		String sql="SELECT * FROM ForeignIdentity WHERE foreignIdentityId="+foreignIdentityId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				foreignIdentity=Packager.PackagerForeignIdeneity(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return foreignIdentity;
	}

	@Override
	public List<ForeignIdentity> getAllForeignIdeneity() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ForeignIdentity> foreignIdentities=new ArrayList<ForeignIdentity>();
		String sql="SELECT * FROM ForeignIdentity";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				foreignIdentities.add(Packager.PackagerForeignIdeneity(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return foreignIdentities;
	}

	@Override
	public int save(ForeignIdentity foreignIdentity, Connection conn) {
		String sql="INSERT INTO ForeignIdentity VALUES(?,?,?,?,?,?,?)";
		Object[] param={
			foreignIdentity.getNationalityId(),
			foreignIdentity.getBirthplace(),
			foreignIdentity.getHomeAddress(),
			foreignIdentity.getPhone(),
			foreignIdentity.getEducationId(),
			foreignIdentity.isMarried(),
			foreignIdentity.getBirthday()
		};
		int foreignIdeneityId=save(sql, param, conn);
		return foreignIdeneityId;
	}

	@Override
	public void update(ForeignIdentity foreignIdentity) {
		StringBuilder sql=new StringBuilder("UPDATE ForeignIdentity SET isMarried=?");
		ArrayList<Object> paramForeignIdentity=new ArrayList<Object>();
		paramForeignIdentity.add(foreignIdentity.isMarried());
		
		if(foreignIdentity.getNationalityId()!=0)
		{
			sql.append(", nationalityId=?");
			paramForeignIdentity.add(foreignIdentity.getNationalityId());
		}
		
		if(foreignIdentity.getBirthplace()!=null||!"".equals(foreignIdentity.getBirthplace()))
		{
			sql.append(", birthplace=?");
			paramForeignIdentity.add(foreignIdentity.getBirthplace());
		}
		
		if(foreignIdentity.getHomeAddress()!=null||!"".equals(foreignIdentity.getHomeAddress()))
		{
			sql.append(", homeAddress=?");
			paramForeignIdentity.add(foreignIdentity.getHomeAddress());
		}
		
		if(foreignIdentity.getPhone()!=null||!"".equals(foreignIdentity.getPhone()))
		{
			sql.append(", phone=?");
			paramForeignIdentity.add(foreignIdentity.getPhone());
		}
		
		if(foreignIdentity.getEducationId()!=0)
		{
			sql.append(", educationId=?");
			paramForeignIdentity.add(foreignIdentity.getEducationId());
		}
		
		if(foreignIdentity.getBirthday()!=null||!"".equals(foreignIdentity.getBirthday()))
		{
			sql.append(", birthday=?");
			paramForeignIdentity.add(foreignIdentity.getBirthday());
		}
		
		Object[] param=paramForeignIdentity.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
	}

	@Override
	public void delete(int foreignIdeneityId, String phone, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM FoerignIdentity WHERE 1=1 ");
		try
		{
			if(foreignIdeneityId!=0)
			{
				sql.append(type+"foreignIdentityId="+foreignIdeneityId+" ");
			}
			
			if(phone!=null||!"".equals(phone))
			{
				sql.append(type+" phone="+phone+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
