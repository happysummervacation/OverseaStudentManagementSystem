package com.osms.dao;

import java.util.List;

import com.osms.entity.Notice;

public interface NoticeDao {

	/**
	 * 通过通知表id查找通知信息
	 * @param noticeId
	 * @return
	 */
	public Notice getNoticeByNoticeId(int noticeId);
	
	/**
	 * 获取所有通知信息
	 * @return
	 */
	public List<Notice> getAllNotice();
	
	/**
	 * 保存一条通知信息
	 * @param notice
	 */
	public void save(Notice notice);
	
	/**
	 * 更新一条通知信息
	 * @param notice
	 */
	public void update(Notice notice);
	
	/**
	 * 删除操作
	 * @param noticeId
	 * 		关键字
	 * @param userId
	 * 		关键字
	 * @param noticeTypeId
	 * 		关键字
	 * @param type
	 * 		关键字操作：并操作OR或操作
	 */
	public void delete(int noticeId, int userId, int noticeTypeId, String type);
}
