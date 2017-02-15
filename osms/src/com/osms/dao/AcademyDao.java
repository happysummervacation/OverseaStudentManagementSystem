package com.osms.dao;

import java.util.List;

import com.osms.entity.Academy;

public interface AcademyDao {

	/**
	 * 通过学院ID号检索学院名称
	 * @param academyId
	 * 		int
	 * @return
	 * 		Academy
	 */
	public Academy getAcademyByAcademyId(int academyId);
	
	/**
	 * 获取所有学院名称
	 * @return
	 */
	public List<Academy> getAllAcademy();
	
	/**
	 * 保存一个学院名称
	 * @param academy
	 */
	public void save(Academy academy);
	
	/**
	 * 更新学院名称
	 * @param academy
	 */
	public void update(Academy academy);
	
	/**
	 * 删除操作
	 * @param academyId
	 * 		关键字
	 * @param academyName
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int academyId, String academyName, String type);
}
