package com.osms.dao;

import java.util.List;

import com.osms.entity.NoticeType;

public interface NoticeTypeDao {

	/**
	 * 通过通知类型配置表id获取通知类型
	 * @param noticeTypeId
	 * @return
	 */
	public NoticeType getNoticeTypeByNoticeTypeId(int noticeTypeId);
	
	/**
	 * 获取所有通知类型
	 * @return
	 */
	public List<NoticeType> getAllNoticeType();
	
	/**
	 * 保存一种通知类型
	 * @param noticeType
	 */
	public void save(NoticeType noticeType);
	
	/**
	 * 更新一种通知类型
	 * @param noticeType
	 */
	public void update(NoticeType noticeType);
	
	/**
	 * 删除操作
	 * @param noticeTypeId
	 * 		关键字
	 * @param noticeTypeName
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int noticeTypeId, String noticeTypeName, String type);
}
