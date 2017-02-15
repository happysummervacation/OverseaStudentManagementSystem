package com.osms.dao;

import java.util.List;

import com.osms.entity.Nationality;

public interface NationalityDao {

	/**
	 * 通过国籍表id检索国籍信息
	 * @param nationalityId
	 * @return
	 */
	public Nationality getNationalityByNationalityId(int nationalityId);
	
	
	/**
	 * 查找所有国籍信息
	 * @return
	 */
	public List<Nationality> getAllNationality();
	
	/**
	 * 根据查找条件进行模糊查找所有国籍信息
	 * 若条件为空，默认查找所有
	 * @return
	 */
	public List<Nationality> getNationalityByCondition(String condition);
	
	
	/**
	 * 保存一个国家信息
	 * @param nationality
	 */
	public void save(Nationality nationality);
	
	
	/**
	 * 更新一个国家信息
	 * @param nationality
	 */
	public void update(Nationality nationality);
	
	
	/**
	 * 删除操作
	 * @param nationalityId
	 * 			关键字
	 * @param nationalityChineseName
	 * 			关键字
	 * @param nationalityEnglishName
	 * 			关键字
	 * @param type
	 * 			关键字操作：并操作OR或操作
	 */
	public void delete(int nationalityId, String nationalityChineseName, String nationalityEnglishName, String type);
}
