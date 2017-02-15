package com.osms.entity;

import java.io.Serializable;
/**
 * 通知类别配置表
 * @author Administrator
 *
 */
public class NoticeType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int noticeTypeId=0;//通知类别ID
	private String NoticeTypeName=null;//通知类别名称
	
	public NoticeType()
	{
		
	}
	
	public NoticeType(int noticeTypeId, String noticeTypeName) {
	//	super();
		this.noticeTypeId = noticeTypeId;
		NoticeTypeName = noticeTypeName;
	}

	public int getNoticeTypeId() {
		return noticeTypeId;
	}

	public void setNoticeTypeId(int noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}

	public String getNoticeTypeName() {
		return NoticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
		NoticeTypeName = noticeTypeName;
	}

	@Override
	public String toString() {
		return "NoticeType [noticeTypeId=" + noticeTypeId + ", NoticeTypeName=" + NoticeTypeName + "]";
	}
	
	
}
