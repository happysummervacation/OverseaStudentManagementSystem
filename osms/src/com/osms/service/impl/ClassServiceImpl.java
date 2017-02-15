package com.osms.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osms.dao.AMCDao;
import com.osms.dao.ClassDao;
import com.osms.dao.jdbc.JDBCUtil;
import com.osms.entity.AMC;
import com.osms.entity.Class;
import com.osms.service.ClassService;

@Service("classService")
public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassDao classDao;
	
	@Autowired
	AMCDao amcDao;
	
	@Override
	public void saveClass(Class cclass, AMC amc) {
		
		//获取对应的amcId
		int amcId=amcDao.getAmcIdByAcademyIdAndMajorId(amc);
		amc.setAmcId(amcId);
		
		Connection conn=JDBCUtil.getConnection();
		try
		{
			conn.setAutoCommit(false);
			
			//保存班级信息
			int classId=classDao.save(cclass, conn);
			
			//保存classId信息
			amc.setClassId(classId);
			
			//事务提交
			conn.commit();
			
			//更新AMC表信息
			amcDao.update(amc);
		} catch (SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(conn);
		}
		
	}

}
