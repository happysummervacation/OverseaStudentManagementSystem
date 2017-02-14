package com.osms.text;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.osms.dao.jdbc.UserDaoImpl;
import com.osms.entity.ForeignIdentity;
import com.osms.entity.Passport;
import com.osms.entity.SchoolRoll;
import com.osms.entity.StudyPeriod;
import com.osms.entity.Users;
import com.osms.entity.Visa;
import com.osms.utils.Utils;

public class StudentTest{

	@Test
	public void textCodeNumber() {
		Passport passport=new Passport();
		passport.setPassportNum("12345dafsd23");
		passport.setPassportPage("qwerty;3212425;dasewqew;32fsr32");
		
		
		Visa visa=new Visa();
		visa.setRegisterDeadline("2017-9-12");
		visa.setIntermediary("nameinter");
		visa.setIntermediaryPhone("17855833097");
		visa.setGuaranteeName("namegua");
		visa.setGuaranteePhone("17855833087");
		visa.setFundingSourceId(1);
		visa.setPassport(passport);
		visa.setApprovalTime(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		visa.setVisaDueTime(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		
		StudyPeriod studyPeriod=new StudyPeriod();
		studyPeriod.setStartTime(null);
		studyPeriod.setEndTime(null);
		
		SchoolRoll schoolRoll=new SchoolRoll();
		schoolRoll.setMajorId(1);
		schoolRoll.setStudyPeriod(studyPeriod);;
		schoolRoll.setWorkOrStudyPlace("place");
		schoolRoll.setStudentType("留学生");
		schoolRoll.setStudentNum("14401010410");
		schoolRoll.setClassId(1);
		schoolRoll.setAcademyId(1);
		schoolRoll.setDormitoryNum("13#608");
		schoolRoll.setStudentCardNum("14401010410");
		schoolRoll.setComeTime(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		schoolRoll.setLeaveTime(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		schoolRoll.setStatusId(1);
		
		
		ForeignIdentity foreignIdentity=new ForeignIdentity();
		foreignIdentity.setNationalityId(1);
		foreignIdentity.setBirthplace("place");
		foreignIdentity.setHomeAddress("address");
		foreignIdentity.setPhone("17855833928");
		foreignIdentity.setEducationId(1);
		foreignIdentity.setMarried(false);
		foreignIdentity.setBirthday(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		
		Users user=new Users();
		user.setFullName("mark");
		user.setGender(false);
		user.setTypeId(1);
		user.setPhone("17855832336");
		user.setEmail("2539d2328@qq.com");
		user.setPassword(Utils.toMD5("123456"));
		user.setForeignIdentity(foreignIdentity);
		user.setVisa(visa);
		user.setSchoolRoll(schoolRoll);
		user.setStatus(1);
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.setHook(true);//是否勾上代码块，学习期限表是否需要用
		userDaoImpl.saveStudent(user);
	}

}
