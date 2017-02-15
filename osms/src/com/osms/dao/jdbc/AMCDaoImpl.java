package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.AMCDao;
import com.osms.entity.AMC;
import com.osms.utils.Packager;

@Repository("amcDao")
public class AMCDaoImpl extends JDBCBase implements AMCDao {
	
	@Override
	public AMC getAMCByAmcId(int amcId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		AMC amc=null;
		String sql="SELECT * FROM AMC WHERE amcId="+amcId;
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				amc=Packager.PackagerAMC(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return amc;
	}
	
	
	@Override
	public List<AMC> getAMCByAcademyId(int academyId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AMC> amcs=new ArrayList<AMC>();
		String sql="SELECT * FROM AMC WHERE academyId="+academyId;
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				amcs.add(Packager.PackagerAMC(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return amcs;
	}
	
	
	@Override
	public int save(AMC amc, Connection conn) {
		
		String sql="INSERT INTO AMC VALUES(?,?,?)";
		Object[] paramAMC={
			amc.getAcademyId(),
			amc.getMajorId(),
			amc.getClassId()
		};
		int amcId=save(sql, paramAMC, conn);
		return amcId;
	}

	@Override
	public int getAmcIdByAcademyIdAndMajorId(AMC amc) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT amcId FROM AMC WHERE academyId=? AND majorId=? AND classId IS NULL";
		int amcId=-1;
		Object[] param={
			amc.getAcademyId(),
			amc.getMajorId()
		};
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps, param);
			if(rs.next())
			{
				amcId=rs.getInt("amcId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return amcId;
	}

	@Override
	public void update(AMC amc) {
		String sql="UPDATE AMC SET academyId=?, majorId=?, classId=? WHERE amcId=?";
		Object[] param={
			amc.getAcademyId(),
			amc.getMajorId(),
			amc.getClassId(),
			amc.getAmcId()
		};
		saveOrUpdateOrDelete(sql, param);
	}


	@Override
	public void delete(int amcId, int academyId, int majorId, int classId, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM AMC WHERE 1=1 ");
		try
		{
			if(amcId!=0)
			{
				sql.append(type+"WHERE amcId="+amcId+" ");
			}
			
			if(academyId!=0)
			{
				sql.append(type+"academyId="+academyId+" ");
			}
			
			if(majorId!=0)
			{
				sql.append(type+"majorId="+majorId+" ");
			}
			
			if(classId!=0)
			{
				sql.append(type+"classId="+classId+" ");
			}
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}



}
