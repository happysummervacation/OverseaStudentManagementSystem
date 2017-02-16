package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.PassportDao;
import com.osms.entity.Passport;
import com.osms.utils.Packager;

@Repository("passportDao")
public class PassportDaoImpl extends JDBCBase implements PassportDao {

	@Override
	public Passport getPassportByPassportId(int passportId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Passport passport=null;
		String sql="SELECT * FROM Passport WHERE passportId="+passportId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				passport=Packager.PackagerPassport(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return passport;
	}

	@Override
	public Passport getPassportByPassportNum(String passportNum) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Passport passport=null;
		String sql="SELECT * FROM Passport WHERE passportNum="+passportNum;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				passport=Packager.PackagerPassport(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return passport;
	}

	@Override
	public List<Passport> getAllPassport() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Passport> passports=new ArrayList<Passport>();
		String sql="SELECT * FROM Passport";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				passports.add(Packager.PackagerPassport(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return passports;
	}

	@Override
	public int save(Passport passport, Connection conn) {
		String sql="INSERT INTO Passport VALUES(?,?)";
		Object[] parma={
			passport.getPassportNum(),
			passport.getPassportPage()
		};
		int passportId=save(sql, parma, conn);
		return passportId;
	}

	@Override
	public void update(Passport passport) {
		String sql="UPDATE Passport SET passportNum=?, passportPage=? WHERE passportId=?";
		Object[] parma={
			passport.getPassportNum(),
			passport.getPassportPage()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void delete(int passportId, String passportNum, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Passport WHERE 1=1 ");
		try
		{
			if(passportId!=0)
			{
				sql.append(type+"passportId="+passportId+" ");
			}
			
			if(passportNum!=null||!"".equals(passportNum))
			{
				sql.append(type+" passportNum="+passportNum+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
