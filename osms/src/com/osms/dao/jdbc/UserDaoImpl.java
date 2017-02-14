package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osms.dao.UserDao;
import com.osms.entity.ForeignIdentity;
import com.osms.entity.Passport;
import com.osms.entity.SchoolRoll;
import com.osms.entity.StudyPeriod;
import com.osms.entity.Users;
import com.osms.entity.Visa;
import com.osms.utils.Packager;

public class UserDaoImpl extends JDBCBase implements UserDao{

	//动态勾上代码块，区分来校时间、离校时间和入学时间及毕业时间
	private boolean hook=false;
	
	public void setHook(boolean hook)
	{
		this.hook=hook;
	}
	
	
	@Override
	public Users getUserByUserId(int userId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Users user=null;
		
		String sql="SELECT * FROM Users WHERE userId="+userId;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				user=Packager.PackagerUser(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return user;
	}

	@Override
	public List<Users> getUsers(int typeId) {
		List<Users> users=new ArrayList<Users>();
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM Users WHERE typeId="+typeId;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				users.add(Packager.PackagerUser(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	/**
	 * 事务提交
	 * 顺序：护照页表->签证表、(hook)[学期期限表]->学籍表、国外身份表、Users表
	 */
	@Override
	public void saveStudent(Users user) {
		String sql="INSERT INTO Passport VALUES(?,?)";
		
		//护照信息
		Passport passport=user.getVisa().getPassport();
		
		Object[] paramPassport={
			passport.getPassportNum(),
			passport.getPassportPage()
		};
		//保存护照页信息并获取ID值
		int passportId=save(sql, paramPassport);
		
		sql="INSERT INTO Visa VALUES(?,?,?,?,?,?,?,?,?)";
		//签证信息
		Visa visa=user.getVisa();
		Object[] paramVisa={
			visa.getRegisterDeadline(),
			visa.getIntermediary(),
			visa.getIntermediaryPhone(),
			visa.getGuaranteeName(),
			visa.getGuaranteePhone(),
			visa.getFundingSourceId(),
			passportId,
			visa.getApprovalTime(),
			visa.getVisaDueTime()
		};
		//保存签证信息，并获取ID值
		int visaId=save(sql, paramVisa);
		
		/**
		 * 通过钩子动态调整
		 * 是否需要增加代码块
		 */
		
		//需要-true
		String schoolRoolId=null;
		if(hook)
		{
			sql="INSERT INTO StudyPeriod VALUES(?,?)";
			//学习期限表
			StudyPeriod studyPeriod=user.getSchoolRoll().getStudyPeriod();
			Object[] paramStudyPeroid={
				studyPeriod.getStartTime(),
				studyPeriod.getEndTime()
			};
			//保存学习期限信息，并获取ID值
			int periodId=save(sql, paramStudyPeroid);
			
			sql="INSERT INTO SchoolRoll VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			//学籍信息表
			SchoolRoll schoolRoll=user.getSchoolRoll();
			Object[] paramSchoolRool={
				schoolRoll.getMajorId(),
				periodId,
				schoolRoll.getWorkOrStudyPlace(),
				schoolRoll.getStudentType(),
				schoolRoll.getStudentNum(),
				schoolRoll.getClassId(),
				schoolRoll.getAcademyId(),
				schoolRoll.getDormitoryNum(),
				schoolRoll.getStudentCardNum(),
				schoolRoll.getComeTime(),
				schoolRoll.getLeaveTime(),
				schoolRoll.getStatusId()
			};
			//保存学籍信息，并获取ID值
			schoolRoolId=save(sql, paramSchoolRool)+"";
		}else
		{
			//学籍信息表
			sql="INSERT INTO SchoolRoll VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			//学籍信息表
			SchoolRoll schoolRoll=user.getSchoolRoll();
			Object[] paramSchoolRool={
				schoolRoll.getMajorId(),
				null,
				schoolRoll.getWorkOrStudyPlace(),
				schoolRoll.getStudentType(),
				schoolRoll.getStudentNum(),
				schoolRoll.getClassId(),
				schoolRoll.getAcademyId(),
				schoolRoll.getDormitoryNum(),
				schoolRoll.getStudentCardNum(),
				schoolRoll.getComeTime(),
				schoolRoll.getLeaveTime(),
				schoolRoll.getStatusId()
			};
			//保存学籍信息，并获取ID值
			schoolRoolId=save(sql, paramSchoolRool)+"";
		}
		
		
		
		//国外身份表
		sql="INSERT INTO ForeignIdentity VALUES(?,?,?,?,?,?,?)";
		ForeignIdentity foreignIdentity=user.getForeignIdentity();
		Object[] paramForeignIdentity={
			foreignIdentity.getNationalityId(),
			foreignIdentity.getBirthplace(),
			foreignIdentity.getHomeAddress(),
			foreignIdentity.getPhone(),
			foreignIdentity.getEducationId(),
			foreignIdentity.isMarried(),
			foreignIdentity.getBirthday()
		};
		//保存国外身份信息并获取ID值
		int ForeignIdentityId=save(sql, paramForeignIdentity);
		
		//Users表
		sql="INSERT INTO Users VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] paramUser={
			user.getFullName(),
			user.isGender(),
			user.getTypeId(),
			user.getPhone(),
			user.getEmail(),
			user.getPassword(),
			ForeignIdentityId,
			visaId,
			schoolRoolId,
			user.getStatus()
		};
		//保存user信息
		saveOrUpdateOrDelete(sql, paramUser);
		
	}

	@Override
	public void saveTeacher(Users user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Users user) {
		StringBuilder sql= new StringBuilder("UPDATE Users SET foreignIdentityId=?, visaId=?, schoolRollId=?, gender=?, typeId=?, status=?");
		ArrayList<Object> paramList=new ArrayList<Object>();
		paramList.add(user.getForeignIdentityId());
		paramList.add(user.getVisaId());
		paramList.add(user.getSchoolRollId());
		paramList.add(user.isGender());
		paramList.add(user.getTypeId());
		paramList.add(user.getStatus());
		
		if(user.getFullName()!=null)
		{
			sql.append(", fullName=?");
			paramList.add(user.getFullName());
		}
		
		if(user.getPhone()!=null)
		{
			sql.append(", phone=?");
			paramList.add(user.getPhone());
		}
		
		if(user.getEmail()!=null)
		{
			sql.append(", email=?");
			paramList.add(user.getEmail());
		}
		
		if(user.getPassword()!=null)
		{
			sql.append(", password=?");
			paramList.add(user.getPassword());
		}
		
		sql.append(" WHERE userId=?");
		paramList.add(user.getUserId());
		
		Object[] param=paramList.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
	}

}
