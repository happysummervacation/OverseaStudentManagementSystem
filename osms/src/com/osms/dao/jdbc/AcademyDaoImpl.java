package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.AcademyDao;
import com.osms.entity.Academy;
import com.osms.utils.Packager;

@Repository("academyDao")
public class AcademyDaoImpl extends JDBCBase implements AcademyDao {

	@Override
	public Academy getAcademyByAcademyId(int academyId) {
		Connection conn=JDBCUtil.getConnection();
		String sql="SELECT * FROM Academy WHERE academyId="+academyId;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Academy academy=null;
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				academy=Packager.PackagerAcademy(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return academy;
	}

	@Override
	public List<Academy> getAllAcademy() {
		Connection conn=JDBCUtil.getConnection();
		String sql="SELECT * FROM Academy";
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Academy> academies = new ArrayList<Academy>();
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				academies.add(Packager.PackagerAcademy(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return academies;
	}

	@Override
	public void save(Academy academy) {
		String sql="INSERT INTO Academy VALUES(?)";
		Object[] param={
			academy.getAcademyName()	
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(Academy academy) {
		StringBuilder sql=new StringBuilder("UPDATE Academy SET academyName=?");
		ArrayList<Object> paramAcademy=new ArrayList<Object>();
		paramAcademy.add(academy.getAcademyName());
		sql.append(" WHERE academyId=?");
		paramAcademy.add(academy.getAcademyId());
		Object[] param=paramAcademy.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
	}

	@Override
	public void delete(int academyId, String academyName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Academy WHERE 1=1 ");
		try
		{
			if(academyId!=0)
			{
				sql.append(type+"academyId="+academyId+" ");
			}
			
			if(academyName!=null||!"".equals(academyName))
			{
				sql.append(type+" academyName="+academyName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
