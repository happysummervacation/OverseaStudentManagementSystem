package com.osms.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osms.dao.AMCDao;
import com.osms.dao.MajorDao;
import com.osms.dao.jdbc.JDBCUtil;
import com.osms.entity.AMC;
import com.osms.entity.Major;
import com.osms.service.MajorService;

@Service("majorService")
public class MajorServiceImpl implements MajorService {

	@Autowired
	MajorDao majorDao;
	
	@Autowired
	AMCDao amcDao;
	
	@Override
	public void saveMajor(Major major, AMC amc) {
		Connection conn=JDBCUtil.getConnection();
		try
		{
			//保存专业信息
			conn.setAutoCommit(false);
			int majorId=majorDao.save(major, conn);
			amc.setMajorId(majorId);
			
			//保存AMC表信息
			amcDao.save(amc, conn);
			
			//事务提交
			conn.commit();
		} catch (SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(conn);
		}
	}

}
