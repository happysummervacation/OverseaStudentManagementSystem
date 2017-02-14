package com.osms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学籍信息表
 * @author Administrator
 *
 */
public class SchoolRoll implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int schoolRollId;//学籍Id
	private int majorId;//专业ID
	private int periodId;//学习期限id
	private String workOrStudyPlace;//工作或学习单位
	private String studentType;//学生类别,留学生
	private String studentNum;//学号
	private int classId;//班级ID
	private int academyId;//学院ID
	private String dormitoryNum;//宿舍号
	private String studentCardNum;//学生卡卡号
	private Date comeTime;//来校时间
	private Date leaveTime;//离校时间
	private int statusId;//状态ID
	
	/**
	 * 包含聚合类对象
	 */
	private Major major;//专业配置类对象
	private StudyPeriod studyPeriod;//学习期限配置类对象
	private Class CClass;//班级配置类对象
	private Academy academy;//学院配置类对象
	private Status status;//在校状态对象
	
	
	public SchoolRoll()
	{
		
	}
	
	/**
	 * 聚合类对象构造函数
	 * @param major
	 * @param studyPeriod
	 * @param cClass
	 * @param academy
	 * @param status
	 */
	public SchoolRoll(Major major, StudyPeriod studyPeriod, Class cClass, Academy academy, Status status) {
		this.major = major;
		this.studyPeriod = studyPeriod;
		CClass = cClass;
		this.academy = academy;
		this.status = status;
	}


	/**
	 * 私有成员变量构造函数
	 * @param schoolRollId
	 * @param majorId
	 * @param periodId
	 * @param workOrStudyPlace
	 * @param studentType
	 * @param studentNum
	 * @param classId
	 * @param academyId
	 * @param dormitoryNum
	 * @param studentCardNum
	 * @param comeTime
	 * @param leaveTime
	 * @param statusId
	 */
	
	public SchoolRoll(int schoolRollId, int majorId, int periodId, String workOrStudyPlace, String studentType,
			String studentNum, int classId, int academyId, String dormitoryNum, String studentCardNum, Date comeTime,
			Date leaveTime, int statusId) {
		this.schoolRollId = schoolRollId;
		this.majorId = majorId;
		this.periodId = periodId;
		this.workOrStudyPlace = workOrStudyPlace;
		this.studentType = studentType;
		this.studentNum = studentNum;
		this.classId = classId;
		this.academyId = academyId;
		this.dormitoryNum = dormitoryNum;
		this.studentCardNum = studentCardNum;
		this.comeTime = comeTime;
		this.leaveTime = leaveTime;
		this.statusId = statusId;
	}
	
	
	/**
	 * 构造函数
	 * 私有成员
	 * 聚合对象
	 * @param schoolRollId
	 * @param majorId
	 * @param periodId
	 * @param workOrStudyPlace
	 * @param studentType
	 * @param studentNum
	 * @param classId
	 * @param academyId
	 * @param dormitoryNum
	 * @param studentCardNum
	 * @param comeTime
	 * @param leaveTime
	 * @param statusId
	 * @param major
	 * @param studyPeriod
	 * @param cClass
	 * @param academy
	 * @param status
	 */
	public SchoolRoll(int schoolRollId, int majorId, int periodId, String workOrStudyPlace, String studentType,
			String studentNum, int classId, int academyId, String dormitoryNum, String studentCardNum, Date comeTime,
			Date leaveTime, int statusId, Major major, StudyPeriod studyPeriod, Class cClass, Academy academy,
			Status status) {
		this.schoolRollId = schoolRollId;
		this.majorId = majorId;
		this.periodId = periodId;
		this.workOrStudyPlace = workOrStudyPlace;
		this.studentType = studentType;
		this.studentNum = studentNum;
		this.classId = classId;
		this.academyId = academyId;
		this.dormitoryNum = dormitoryNum;
		this.studentCardNum = studentCardNum;
		this.comeTime = comeTime;
		this.leaveTime = leaveTime;
		this.statusId = statusId;
		this.major = major;
		this.studyPeriod = studyPeriod;
		CClass = cClass;
		this.academy = academy;
		this.status = status;
	}

	public int getSchoolRollId() {
		return schoolRollId;
	}
	public void setSchoolRollId(int schoolRollId) {
		this.schoolRollId = schoolRollId;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public int getPeriodId() {
		return periodId;
	}
	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}
	public String getWorkOrStudyPlace() {
		return workOrStudyPlace;
	}
	public void setWorkOrStudyPlace(String workOrStudyPlace) {
		this.workOrStudyPlace = workOrStudyPlace;
	}
	public String getStudentType() {
		return studentType;
	}
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getAcademyId() {
		return academyId;
	}
	public void setAcademyId(int academyId) {
		this.academyId = academyId;
	}
	public String getDormitoryNum() {
		return dormitoryNum;
	}
	public void setDormitoryNum(String dormitoryNum) {
		this.dormitoryNum = dormitoryNum;
	}
	public String getStudentCardNum() {
		return studentCardNum;
	}
	public void setStudentCardNum(String studentCardNum) {
		this.studentCardNum = studentCardNum;
	}
	public Date getComeTime() {
		return comeTime;
	}
	public void setComeTime(Date comeTime) {
		this.comeTime = comeTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public StudyPeriod getStudyPeriod() {
		return studyPeriod;
	}

	public void setStudyPeriod(StudyPeriod studyPeriod) {
		this.studyPeriod = studyPeriod;
	}

	public Class getCClass() {
		return CClass;
	}

	public void setCClass(Class cClass) {
		CClass = cClass;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SchoolRoll [schoolRollId=" + schoolRollId + ", majorId=" + majorId + ", periodId=" + periodId
				+ ", workOrStudyPlace=" + workOrStudyPlace + ", studentType=" + studentType + ", studentNum="
				+ studentNum + ", classId=" + classId + ", academyId=" + academyId + ", dormitoryNum=" + dormitoryNum
				+ ", studentCardNum=" + studentCardNum + ", comeTime=" + comeTime + ", leaveTime=" + leaveTime
				+ ", statusId=" + statusId + ", major=" + major + ", studyPeriod=" + studyPeriod + ", CClass=" + CClass
				+ ", academy=" + academy + ", status=" + status + "]";
	}
	
	
}
