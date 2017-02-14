package com.osms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 学习期限表
 * @author Administrator
 *
 */
public class StudyPeriod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int periodId;//学习期限id
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	
	public StudyPeriod()
	{
		
	}
	
	public StudyPeriod(int periodId, Date startTime, Date endTime) {
		this.periodId = periodId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getPeriodId() {
		return periodId;
	}
	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "StudyPeriod [periodId=" + periodId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
