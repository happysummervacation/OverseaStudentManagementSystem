package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.osms.dao.SchoolRollDao;
import com.osms.entity.SchoolRoll;
import com.osms.utils.Packager;

@Repository("schoolRollDao")
public class SchoolRollDaoImpl extends JDBCBase implements SchoolRollDao {

	@Override
	public SchoolRoll getSchoolRollByschoolRoolId(int schoolRollId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		SchoolRoll schoolRoll=null;
		String sql="SELECT * FROM SchoolRoll WHERE schoolRollId="+schoolRollId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				schoolRoll=Packager.PackagerSchoolRoll(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return schoolRoll;
	}

	@Override
	public int save(SchoolRoll schoolRoll, Connection conn) {
		String sql="INSERT INTO SchoolRoll VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] param={
			schoolRoll.getPeriodId(),
			schoolRoll.getWorkOrStudyPlace(),
			schoolRoll.getSchoolRollName(),
			schoolRoll.getAmcId(),
			schoolRoll.getDormitoryNum(),
			schoolRoll.getCardNum(),
			schoolRoll.getComeTime(),
			schoolRoll.getLeaveTime(),
			schoolRoll.getStatusId()
		};
		int schoolRollId=save(sql, param, conn);
		return schoolRollId;
	}

	@Override
	public void update(SchoolRoll schoolRoll) {
		StringBuilder sql=new StringBuilder("UPDATE SchoolRoll SET dormitoryNum=?");
		ArrayList<Object> paramSchoolRoll=new ArrayList<Object>();
		paramSchoolRoll.add(schoolRoll.getDormitoryNum());
		
		if(schoolRoll.getPeriodId()!=0)
		{
			sql.append(", periodId=?");
			paramSchoolRoll.add(schoolRoll.getPeriodId());
		}
		
		if(schoolRoll.getWorkOrStudyPlace()!=null||!"".equals(schoolRoll.getWorkOrStudyPlace()))
		{
			sql.append(", workOrStudyPlace=?");
			paramSchoolRoll.add(schoolRoll.getWorkOrStudyPlace());
		}
		
		if(schoolRoll.getSchoolRollName()!=null||!"".equals(schoolRoll.getSchoolRollName()))
		{
			sql.append(", schoolRollName=?");
			paramSchoolRoll.add(schoolRoll.getSchoolRollName());
		}
		
		if(schoolRoll.getAmcId()!=0)
		{
			sql.append(", amcId=?");
			paramSchoolRoll.add(schoolRoll.getAmcId());
		}
		
		if(schoolRoll.getCardNum()!=null||!"".equals(schoolRoll.getCardNum()))
		{
			sql.append(", cardNum=?");
			paramSchoolRoll.add(schoolRoll.getCardNum());
		}
		
		if(schoolRoll.getComeTime()!=null||!"".equals(schoolRoll.getComeTime()))
		{
			sql.append(", comeTime=?");
			paramSchoolRoll.add(schoolRoll.getComeTime());
		}
		
		if(schoolRoll.getLeaveTime()!=null||!"".equals(schoolRoll.getLeaveTime()))
		{
			sql.append(", leaveTime=?");
			paramSchoolRoll.add(schoolRoll.getLeaveTime());
		}
		
		if(schoolRoll.getStatusId()!=0)
		{
			sql.append(", statusId=?");
			paramSchoolRoll.add(schoolRoll.getStatusId());
		}
		
		sql.append(" WHERE schoolRollId=?");
		paramSchoolRoll.add(schoolRoll.getSchoolRollId());
		
		Object[] param=paramSchoolRoll.toArray();
		
		saveOrUpdateOrDelete(sql.toString(), param);
		
	}

	@Override
	public void delete(int schoolRollId, String cardNum, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM SchoolRoll WHERE 1=1 ");
		try
		{
			if(schoolRollId!=0)
			{
				sql.append(type+"schoolRollId="+schoolRollId+" ");
			}
			
			if(cardNum!=null||!"".equals(cardNum))
			{
				sql.append(type+" cardNum="+cardNum+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
