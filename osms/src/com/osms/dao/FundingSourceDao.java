package com.osms.dao;

import java.util.List;

import com.osms.entity.FundingSource;

public interface FundingSourceDao {

	/**
	 * 通过经费配置表ID检索经费来源类型
	 * @param fundingSourceId
	 * @return
	 */
	public FundingSource getFundingSourceByFundingSourceId(int fundingSourceId);
	
	
	/**
	 * 获取所有经费来源类型分
	 * @return
	 */
	public List<FundingSource> getAllFundingSource();
	
	
	/**
	 * 保存一种经费来源
	 * @param fundingSource
	 */
	public void save(FundingSource fundingSource);
	
	
	/**
	 * 更新一种经费来源信息
	 * @param fundingSource
	 */
	public void update(FundingSource fundingSource);
	
	
	/**
	 * 删除操作
	 * @param fundingSourceId
	 * 		关键字
	 * @param fundingSourceName
	 * 		关键字
	 * @param type
	 * 		关键字操作类型：并操作OR或操作
	 */
	public void delete(int fundingSourceId, String fundingSourceName, String type);
}
