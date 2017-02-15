package com.osms.dao;

import java.util.List;

import com.osms.entity.EducationType;

public interface EducationTypeDao {

	/**
	 * 通过学历配置表id检索信息
	 * @param educationId
	 * @return
	 */
	public EducationType getEducationTypeByEducationId(int educationId);
	
	
	/**
	 * 获取所有学历类型
	 * @return
	 */
	public List<EducationType> getAllEducationType();
	
	
	/**
	 * 通过学历名称模糊查找学历
	 * @param educationName
	 * @return
	 */
	public List<EducationType> getEduationTypeByEducationName(String educationName);
	
	
	/**
	 * 保存一种学历信息
	 * @param educationType
	 */
	public void save(EducationType educationType);
	
	
	/**
	 * 更新一种学历信息
	 * @param educationType
	 */
	public void update(EducationType educationType);
	
	
	/**
	 * 删除操作
	 * @param educationId
	 * 		关键字
	 * @param educationName
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int educationId, String educationName, String type);
}
