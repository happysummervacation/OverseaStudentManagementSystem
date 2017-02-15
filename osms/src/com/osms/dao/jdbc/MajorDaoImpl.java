package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.MajorDao;
import com.osms.entity.Major;
import com.osms.utils.Packager;

@Repository("majorDao")
public class MajorDaoImpl extends JDBCBase implements MajorDao {

	@Override
	public Major getMajorByMajorId(int majorId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Major major=null;
		String sql="SELECT * FROM Major WHERE majorId="+majorId;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				major=Packager.PackagerMajor(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return major;
	}

	@Override
	public List<Major> getAllMajor() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Major> majors=new ArrayList<Major>();
		String sql="SELECT * FROM Major";
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				majors.add(Packager.PackagerMajor(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return majors;
	}

	@Override
	public int save(Major major, Connection conn) {
		String sql="INSERT INTO Major VALUES(?,?)";
		Object[] param={
				major.getMajorName()
		};
		int majorId=save(sql, param, conn);
		return majorId;
	}

	@Override
	public void update(Major major) {
		StringBuilder sql=new StringBuilder("UPDATE Major SET majorName=?");
		ArrayList<Object> paramMajor=new ArrayList<Object>();
		paramMajor.add(major.getMajorName());
		sql.append(" WHERE majorId=?");
		paramMajor.add(major.getMajorId());
		Object[] param=paramMajor.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
	}


	@Override
	public void delete(int majorId, String majorName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Major WHERE 1=1 ");
		try
		{
			if(majorId!=0)
			{
				sql.append(type+"majorId="+majorId+" ");
			}
			
			if(majorName!=null||!"".equals(majorName))
			{
				sql.append(type+" majorName="+majorName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
