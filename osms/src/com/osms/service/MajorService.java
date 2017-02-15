package com.osms.service;

import com.osms.entity.AMC;
import com.osms.entity.Major;

public interface MajorService {

	/**
	 * 保存专业信息
	 * @param major
	 * @param amc
	 */
	public void saveMajor(Major major, AMC amc);
}
