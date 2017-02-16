package com.osms.service;

import com.osms.entity.AMC;
import com.osms.entity.ForeignIdentity;
import com.osms.entity.Passport;
import com.osms.entity.SchoolRoll;
import com.osms.entity.StudyPeriod;
import com.osms.entity.Users;
import com.osms.entity.Visa;

public interface UserService {

	/**
	 * 保存一个学生用户对象
	 * @param passport
	 * 		护照对象
	 * @param visa
	 * 		签证对象
	 * @param studyPeriod
	 * 		学习期限对象
	 * @param amc
	 * 		学院专业班级对象
	 * @param schoolRoll
	 * 		学籍对象
	 * @param foreignIdentity
	 * 		国外身份对象
	 * @param users
	 * 		用户对象
	 */
	public void saveStudent(Passport passport, Visa visa,
			StudyPeriod studyPeriod, AMC amc, SchoolRoll schoolRoll,
			ForeignIdentity foreignIdentity, Users user);
	
	
	/**
	 * 保存一个教师对象信息
	 * @param amc
	 * @param schoolRoll
	 * @param user
	 */
	public void saveTeacher(AMC amc, SchoolRoll schoolRoll, Users user);
}
