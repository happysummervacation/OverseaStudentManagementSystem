package com.osms.entity;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int noticeId=0;//通知ID
	private String title=null;//通知标题
	private String content=null;//内容
	private String writer=null;//写作人姓名
	private int userId=0;//写作人Id
	private int noticeTypeId=0;//通知类别ID
	private String downLoadPath=null;//附件下载链接
	private Date publishTime=null;//通知发布时间
	private int status=0;//状态
	
	/**
	 * 包含聚合对象
	 */
	private Users user=null;//用户类对象
	private NoticeType noticeType=null;//通知类别配置类对象
	
	/**
	 * 私有变量构造
	 * @param noticeId
	 * @param title
	 * @param content
	 * @param writer
	 * @param userId
	 * @param noticeTypeId
	 * @param downLoadPath
	 * @param publishTime
	 * @param status
	 */
	public Notice(int noticeId, String title, String content, String writer, int userId, int noticeTypeId,
			String downLoadPath, Date publishTime, int status) {
//		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.userId = userId;
		this.noticeTypeId = noticeTypeId;
		this.downLoadPath=downLoadPath;
		this.publishTime = publishTime;
		this.status=status;
	}

	/**
	 * 聚合对象构造
	 * @param user
	 * @param noticeType
	 */
	public Notice(Users user, NoticeType noticeType) {
//		super();
		this.user = user;
		this.noticeType = noticeType;
	}

	/**
	 * 构造函数
	 * 私有变量
	 * 集合对象
	 * @param noticeId
	 * @param title
	 * @param content
	 * @param writer
	 * @param userId
	 * @param noticeTypeId
	 * @param downLoadPath
	 * @param publishTime
	 * @param status
	 * @param user
	 * @param noticeType
	 */
	public Notice(int noticeId, String title, String content, String writer, int userId, int noticeTypeId,
			String downLoadPath, Date publishTime, int status, Users user, NoticeType noticeType) {
//		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.userId = userId;
		this.noticeTypeId = noticeTypeId;
		this.downLoadPath=downLoadPath;
		this.publishTime = publishTime;
		this.status=status;
		this.user = user;
		this.noticeType = noticeType;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoticeTypeId() {
		return noticeTypeId;
	}

	public void setNoticeTypeId(int noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}

	public String getDownLoadPath() {
		return downLoadPath;
	}

	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", userId=" + userId + ", noticeTypeId=" + noticeTypeId + ", downLoadPath=" + downLoadPath
				+ ", publishTime=" + publishTime + ", status=" + status + ", user=" + user + ", noticeType="
				+ noticeType + "]";
	}
	
	
	
	
}
