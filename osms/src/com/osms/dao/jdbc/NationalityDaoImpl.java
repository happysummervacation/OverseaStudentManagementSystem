package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.NationalityDao;
import com.osms.entity.Nationality;
import com.osms.utils.Packager;

@Repository("nationalityDao")
public class NationalityDaoImpl extends JDBCBase implements NationalityDao {

	@Override
	public Nationality getNationalityByNationalityId(int nationalityId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Nationality nationality=null;
		String sql="SELECT * FROM Nationality WHERE nationalityId="+nationalityId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				nationality=Packager.PackagerNationality(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return nationality;
	}

	@Override
	public List<Nationality> getNationalityByCondition(String condition) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Nationality> nationalities=new ArrayList<Nationality>();
		String sql= "SELECT * FROM Nationality WHERE 1=1 AND (nationalityChineseName=? OR nationalityEnglishName=?)";
		
		Object[] param={
			condition,
			condition
		};
		
		try {
			ps=conn.prepareStatement(sql.toString());
			rs=query(ps, param);
			while(rs.next())
			{
				nationalities.add(Packager.PackagerNationality(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return nationalities;
	}

	@Override
	public List<Nationality> getAllNationality() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Nationality> nationalities=new ArrayList<Nationality>();
		String sql= "SELECT * FROM Nationality";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				nationalities.add(Packager.PackagerNationality(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return nationalities;
	}

	@Override
	public void save(Nationality nationality) {
		String sql="INSERT INTO Nationality VALUES(?,?)";
		Object[] param={
			nationality.getNationalityChineseName(),
			nationality.getNationalityEnglishName()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(Nationality nationality) {
		String sql="UPDATE Nationality SET nationalityChineseName=?, nationalityEnglishName=? WHERE nationalityId=?";
		Object[] param={
			nationality.getNationalityChineseName(),
			nationality.getNationalityEnglishName(),
			nationality.getNationalityId()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(int nationalityId, String nationalityChineseName, String nationalityEnglishName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Nationality WHERE 1=1 ");
		try
		{
			if(nationalityId!=0)
			{
				sql.append(type+"nationalityId="+nationalityId+" ");
			}
			
			if(nationalityChineseName!=null||!"".equals(nationalityChineseName))
			{
				sql.append(type+" nationalityChineseName="+nationalityChineseName+" ");
			}
			
			if(nationalityEnglishName!=null||!"".equals(nationalityEnglishName))
			{
				sql.append(type+" nationalityEnglishName="+nationalityEnglishName+" ");
			}
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
