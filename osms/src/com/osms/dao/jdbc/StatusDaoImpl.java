package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.StatusDao;
import com.osms.entity.Status;
import com.osms.utils.Packager;

@Repository("statusDao")
public class StatusDaoImpl extends JDBCBase implements StatusDao {

	@Override
	public Status getStatusByStatusId(int statusId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Status status=null;
		String sql="SELECT * FROM Status WHERE statusId="+statusId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				status=Packager.PackagerStatus(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return status;
	}

	@Override
	public List<Status> getAllStatus() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Status> status=new ArrayList<Status>();
		String sql="SELECT * FROM Status";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				status.add(Packager.PackagerStatus(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return status;
	}

	@Override
	public void save(Status status) {
		String sql="INSERT INTO Status VALUES(?)";
		Object[] param={
			status.getStatusName()	
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(Status status) {
		String sql="UPDATE Status SET statusName=? WHERE statusId=?";
		Object[] param={
			status.getStatusName(),
			status.getStatusId()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(int statusId, String statusName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Status WHERE 1=1 ");
		try
		{
			if(statusId!=0)
			{
				sql.append(type+"statusId="+statusId+" ");
			}
			
			if(statusName!=null||!"".equals(statusName))
			{
				sql.append(type+" statusName="+statusName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
