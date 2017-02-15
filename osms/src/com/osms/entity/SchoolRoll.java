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
	
	private int schoolRollId=0;//学籍Id
	private int periodId=0;//学习期限id
	private String workOrStudyPlace=null;//工作或学习单位
	private String schoolRollName=null;//职业类型，留学生或者教师职称
	private String cardNum=null;//工号、学生卡号、学号是同一个
	private int amcId=0;//学院专业班级表ID
	private String dormitoryNum=null;//宿舍号
	private Date comeTime=null;//来校时间
	private Date leaveTime=null;//离校时间
	private int statusId=0;//状态ID
	
	/**
	 * 包含聚合类对象
	 */
	private AMC amc=null;//学院专业班级集合表对象
	private StudyPeriod studyPeriod=null;//学习期限配置类对象
	private Status status=null;//在校状态对象
	
	
	public SchoolRoll()
	{
		
	}


	/**
	 * 私有变量
	 * @param schoolRollId
	 * @param periodId
	 * @param workOrStudyPlace
	 * @param schoolRollName
	 * @param cardNum
	 * @param amcId
	 * @param dormitoryNum
	 * @param comeTime
	 * @param leaveTime
	 * @param statusId
	 */
	public SchoolRoll(int schoolRollId, int periodId, String workOrStudyPlace, String schoolRollName, String cardNum,
			int amcId, String dormitoryNum, Date comeTime, Date leaveTime, int statusId) {
		this.schoolRollId = schoolRollId;
		this.periodId = periodId;
		this.workOrStudyPlace = workOrStudyPlace;
		this.schoolRollName = schoolRollName;
		this.cardNum = cardNum;
		this.amcId = amcId;
		this.dormitoryNum = dormitoryNum;
		this.comeTime = comeTime;
		this.leaveTime = leaveTime;
		this.statusId = statusId;
	}


	/**
	 * 聚合对象
	 * @param amc
	 * @param studyPeriod
	 * @param status
	 */
	public SchoolRoll(AMC amc, StudyPeriod studyPeriod, Status status) {
		this.amc = amc;
		this.studyPeriod = studyPeriod;
		this.status = status;
	}


	/**
	 * 私有变量
	 * 聚合对象
	 * @param schoolRollId
	 * @param periodId
	 * @param workOrStudyPlace
	 * @param schoolRollName
	 * @param cardNum
	 * @param amcId
	 * @param dormitoryNum
	 * @param comeTime
	 * @param leaveTime
	 * @param statusId
	 * @param amc
	 * @param studyPeriod
	 * @param status
	 */
	public SchoolRoll(int schoolRollId, int periodId, String workOrStudyPlace, String schoolRollName, String cardNum,
			int amcId, String dormitoryNum, Date comeTime, Date leaveTime, int statusId, AMC amc,
			StudyPeriod studyPeriod, Status status) {
		this.schoolRollId = schoolRollId;
		this.periodId = periodId;
		this.workOrStudyPlace = workOrStudyPlace;
		this.schoolRollName = schoolRollName;
		this.cardNum = cardNum;
		this.amcId = amcId;
		this.dormitoryNum = dormitoryNum;
		this.comeTime = comeTime;
		this.leaveTime = leaveTime;
		this.statusId = statusId;
		this.amc = amc;
		this.studyPeriod = studyPeriod;
		this.status = status;
	}


	public int getSchoolRollId() {
		return schoolRollId;
	}


	public void setSchoolRollId(int schoolRollId) {
		this.schoolRollId = schoolRollId;
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


	public String getSchoolRollName() {
		return schoolRollName;
	}


	public void setSchoolRollName(String schoolRollName) {
		this.schoolRollName = schoolRollName;
	}


	public String getCardNum() {
		return cardNum;
	}


	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}


	public int getAmcId() {
		return amcId;
	}


	public void setAmcId(int amcId) {
		this.amcId = amcId;
	}


	public String getDormitoryNum() {
		return dormitoryNum;
	}


	public void setDormitoryNum(String dormitoryNum) {
		this.dormitoryNum = dormitoryNum;
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


	public AMC getAmc() {
		return amc;
	}


	public void setAmc(AMC amc) {
		this.amc = amc;
	}


	public StudyPeriod getStudyPeriod() {
		return studyPeriod;
	}


	public void setStudyPeriod(StudyPeriod studyPeriod) {
		this.studyPeriod = studyPeriod;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SchoolRoll [schoolRollId=" + schoolRollId + ", periodId=" + periodId + ", workOrStudyPlace="
				+ workOrStudyPlace + ", schoolRollName=" + schoolRollName + ", cardNum=" + cardNum + ", amcId=" + amcId
				+ ", dormitoryNum=" + dormitoryNum + ", comeTime=" + comeTime + ", leaveTime=" + leaveTime
				+ ", statusId=" + statusId + ", amc=" + amc + ", studyPeriod=" + studyPeriod + ", status=" + status
				+ "]";
	}

	
}
