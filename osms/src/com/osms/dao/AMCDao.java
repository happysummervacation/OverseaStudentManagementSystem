package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.AMC;

public interface AMCDao {
	
	/**
	 * 通过amcId检索AMC信息
	 * @param amcId
	 * @return
	 */
	public AMC getAMCByAmcId(int amcId);
	
	
	/**
	 * 通过学院获取学院下的所有专业及专业相关的班级
	 * @param academyId
	 * @return
	 */
	public List<AMC> getAMCByAcademyId(int academyId);
	
	
	/**
	 * 保存一个学院专业班级对象
	 * @param amc
	 */
	public int save(AMC amc, Connection conn);
	
	
	/**
	 * 通过学院id和专业id查找amc记录id值
	 * @param amc
	 * @return
	 */
	public int getAmcIdByAcademyIdAndMajorId(AMC amc);
	
	/**
	 * 更新信息
	 * @param amc
	 */
	public void update(AMC amc);
	
	/**
	 * 删除数据操作
	 * @param amcId
	 * 		关键字 amcId
	 * @param academyId
	 * 		关键字 academyId
	 * @param majorId
	 * 		关键字 majorId
	 * @param classId
	 * 		关键字 classId
	 * @param type
	 * 		并操作Or或操作，写入关键字的组合方式
	 */
	public void delete(int amcId, int academyId, int majorId, int classId, String type);
}
