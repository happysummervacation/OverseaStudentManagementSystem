package com.osms.service;

import com.osms.entity.AMC;
import com.osms.entity.Class;

public interface ClassService {

	/**
	 * 保存班级信息
	 * @param cclass
	 */
	public void saveClass(Class cclass, AMC amc);
}
