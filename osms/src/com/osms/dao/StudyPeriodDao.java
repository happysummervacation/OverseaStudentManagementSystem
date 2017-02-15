package com.osms.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.osms.entity.StudyPeriod;

public interface StudyPeriodDao {

	/**
	 * 通过学习期限表ID检索表信息
	 * @param periodId
	 * @return
	 */
	public StudyPeriod getStudyPeriodByPeriodId(int periodId);
	
	/**
	 * 获取所有学习期限时间段
	 * @return
	 */
	public List<StudyPeriod> getAllStudyPeriod();
	
	/**
	 * 事物提交
	 * 保存一个时间段记录
	 * @param studyPeriod
	 * @param conn
	 * @return
	 */
	public int save(StudyPeriod studyPeriod, Connection conn);
	
	/**
	 * 修改学习期限
	 * @param studyPeriod
	 */
	public void update(StudyPeriod studyPeriod);
	
	/**
	 * 删除操作
	 * @param periodId
	 * 		关键字
	 * @param startTime
	 * 		关键字
	 * @param endTime
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int periodId, Date startTime, Date endTime, String type);
}
