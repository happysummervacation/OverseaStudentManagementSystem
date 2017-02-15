package com.osms.dao;

import java.sql.Connection;
import java.util.List;

import com.osms.entity.Class;

public interface ClassDao {

	/**
	 * 通过班级Id检索
	 * @param classId
	 * @return
	 */
	public Class getClassByclassId(int classId);
	
	
	/**
	 * 获取所有班级信息
	 * @return
	 */
	public List<Class> getAllClass();
	
	
	/**
	 * 更新一个班级信息
	 * @param cclass
	 */
	public void update(Class cclass);
	
	
	/**
	 * 保存一个班级信息
	 * @param cclass
	 * @return
	 * 		classId
	 */
	public int save(Class cclass, Connection conn);
	
	
	/**
	 * 删除操作
	 * @param classId
	 * 		关键字-classId
	 * @param className
	 * 		关键字 className
	 * @param type
	 * 		制定关键字作用类型：并操作Or或操作
	 */
	public void delete(int classId, String className, String type);
}
