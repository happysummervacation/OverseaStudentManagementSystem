package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.EducationTypeDao;
import com.osms.entity.EducationType;
import com.osms.utils.Packager;

@Repository("educationTypeDao")
public class EducationTypeDaoImpl extends JDBCBase implements EducationTypeDao {

	@Override
	public EducationType getEducationTypeByEducationId(int educationId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		EducationType educationType=null;
		String sql="SELECT * FROM EducationType WHERE educationId="+educationId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				educationType=Packager.PackagerEducationType(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return educationType;
	}

	@Override
	public List<EducationType> getAllEducationType() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EducationType>educationTypes=new ArrayList<EducationType>();
		String sql="SELECT * FROM EducationType";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				educationTypes.add(Packager.PackagerEducationType(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return educationTypes;
	}

	@Override
	public List<EducationType> getEduationTypeByEducationName(String educationName) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM EducationType WHERE educationName LIKE %"+educationName+"%";
		List<EducationType> educationTypes=new ArrayList<EducationType>();
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				educationTypes.add(Packager.PackagerEducationType(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return educationTypes;
	}

	@Override
	public void save(EducationType educationType) {
		String sql="INSERT INTO EducationType VALUES(?)";
		Object[] param={
			educationType.getEducationName()	
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(EducationType educationType) {
		String sql="UPDATE EducationType SET educationName=? WHERE educationId=?";
		Object[] param={
			educationType.getEducationName(),
			educationType.getEducationId()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(int educationId, String educationName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM EducationType WHERE 1=1 ");
		try
		{
			if(educationId!=0)
			{
				sql.append(type+"educationId="+educationId+" ");
			}
			
			if(educationName!=null||!"".equals(educationName))
			{
				sql.append(type+" educationName="+educationName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
