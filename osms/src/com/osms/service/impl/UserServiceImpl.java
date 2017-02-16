package com.osms.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osms.dao.AMCDao;
import com.osms.dao.ForeignIdentityDao;
import com.osms.dao.PassportDao;
import com.osms.dao.SchoolRollDao;
import com.osms.dao.StudyPeriodDao;
import com.osms.dao.UserDao;
import com.osms.dao.VisaDao;
import com.osms.dao.jdbc.JDBCUtil;
import com.osms.entity.AMC;
import com.osms.entity.ForeignIdentity;
import com.osms.entity.Passport;
import com.osms.entity.SchoolRoll;
import com.osms.entity.StudyPeriod;
import com.osms.entity.Users;
import com.osms.entity.Visa;
import com.osms.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	PassportDao passportDao;
	
	@Autowired
	VisaDao visaDao;
	
	@Autowired
	StudyPeriodDao studyPeriodDao;
	
	@Autowired
	AMCDao amcDao;
	
	@Autowired
	SchoolRollDao schoolRollDao;
	
	@Autowired
	ForeignIdentityDao foreignIdentityDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void saveStudent(Passport passport, Visa visa, StudyPeriod studyPeriod, AMC amc, SchoolRoll schoolRoll,
			ForeignIdentity foreignIdentity, Users user) {
		
		//获取amcId值
		int amcId=amcDao.getAmcIdByAcademyIdAndMajorIdAndClassId(amc);
		if(amcId!=0)
		{
			schoolRoll.setAmcId(amcId);
		}else
		{
			try {
				throw new Exception("没有相应的学院、专业或班级信息");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//提交用户数据
		Connection conn=JDBCUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//保存护照信息
			int passportId=passportDao.save(passport, conn);
			visa.setPassportId(passportId);
			
			//保存签证信息
			int visaId=visaDao.save(visa, conn);
			user.setVisaId(visaId);
			
			//保存学习期限信息
			int periodId=studyPeriodDao.save(studyPeriod, conn);
			schoolRoll.setPeriodId(periodId);
			
			//保存学籍表信息
			int schoolRollId=schoolRollDao.save(schoolRoll, conn);
			user.setSchoolRollId(schoolRollId);
			
			//保存国外身份信息表
			int foreignIdentityId=foreignIdentityDao.save(foreignIdentity, conn);
			user.setForeignIdentityId(foreignIdentityId);
			
			//保存用户表信息
			userDao.save(user, conn);
			
			//提交事务
			conn.commit();
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(conn);
		}
	}

	@Override
	public void saveTeacher(AMC amc, SchoolRoll schoolRoll, Users user) {
		//获取amcId值
		int amcId=amcDao.getAmcIdByAcademyIdAndMajorIdAndClassId(amc);
		if(amcId!=0)
		{
			schoolRoll.setAmcId(amcId);
		}else
		{
			try {
				throw new Exception("没有相应的学院或专业信息");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//保存教师用户数据
		Connection conn=JDBCUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			
			//保存学籍表信息
			int schoolRollId = schoolRollDao.save(schoolRoll, conn);
			user.setSchoolRollId(schoolRollId);
			
			//保存用户表信息
			userDao.save(user, conn);
			
			//事务提交
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
