package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.StudyPeriodDao;
import com.osms.entity.StudyPeriod;
import com.osms.utils.Packager;

@Repository("studyPeriodDao")
public class StudyPeriodDaoImpl extends JDBCBase implements StudyPeriodDao {

	@Override
	public StudyPeriod getStudyPeriodByPeriodId(int periodId) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudyPeriod studyPeriod = null;
		String sql = "SELECT * FROM StudyPeriod WHERE periodId=" + periodId;
		try {
			ps = conn.prepareStatement(sql);
			rs = query(ps);
			if (rs.next()) {
				studyPeriod = Packager.PackagerStudyPeriod(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return studyPeriod;
	}

	@Override
	public List<StudyPeriod> getAllStudyPeriod() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<StudyPeriod> studyPeriods=new ArrayList<StudyPeriod>();
		String sql="SELECT * FROM StudyPeriod";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				studyPeriods.add(Packager.PackagerStudyPeriod(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return studyPeriods;
	}

	@Override
	public int save(StudyPeriod studyPeriod, Connection conn) {
		String sql="INSERT INTO StudyPeriod VALUES(?,?)";
		Object[] param={
			studyPeriod.getStartTime(),
			studyPeriod.getEndTime()
		};
		int periodId=save(sql, param,conn);
		return periodId;
	}

	@Override
	public void update(StudyPeriod studyPeriod) {
		String sql="UPDATE StudyPeriod SET startTime=?, endTime=? WHERE periodId=?";
		Object[] param={
			studyPeriod.getStartTime(),
			studyPeriod.getEndTime(),
			studyPeriod.getPeriodId()
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(int periodId, Date startTime, Date endTime, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM StudyPeriod WHERE 1=1 ");
		try
		{
			if(periodId!=0)
			{
				sql.append(type+"periodId="+periodId+" ");
			}
			
			if(startTime!=null||!"".equals(startTime))
			{
				sql.append(type+" startTime="+startTime+" ");
			}
			
			if(endTime!=null||!"".equals(endTime))
			{
				sql.append(type+" endTime="+endTime+" ");
			}
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
