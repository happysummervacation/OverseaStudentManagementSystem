package com.osms.globle;

import java.awt.Color;
import java.awt.Font;

/**
 * 常量类，用于管理常量参数
 */
public class Constants {

	/**
	 * 验证码长度
	 */
	public static final Integer IMAGE_WIDTH=120;
	
	/**
	 * 验证码宽度
	 */
	public static final Integer IMAGE_HEIGHT=40;
	
	/**
	 * 验证码字体
	 */
	public static Font[] codeFont={new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30)};
	
	/**
	 * 验证码每个字符颜色
	 */
	public static Color[] color={Color.BLACK,Color.BLUE,Color.RED,Color.DARK_GRAY};
	
	/**
	 * 验证码字库
	 */
	public static final String IMAGE_CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	/**
	 * session中的用户
	 */
	public static String USER = "user";

	/**
	 * 验证码
	 */
	public static String CHECK_NUMBER_NAME = "identify_code";
	
	/**
	 * 错误提示信息
	 */
	public static String ERROR= "error_msg";

	
	/**
	 * 登录页访问次数
	 */
	public static String LOGIN_PAGE = "login.jsp";

	/**
	 * 保存在session中的用户活跃时长统计
	 */
	public static String ACCESS_RECORD_IN_SESSION = "accessList";
		
	/**
	 * 保存在ServletContext中的用户列表
	 */
	public static String ONLINE_USERS = "com.osms.listener.onLineListener.Map";
	
//	/**
//	 * 用户类别配置
//	 */
//	public static String STUDENT="4";
//	
//	public static String TEACHER="3";
//	
//	public static String ADMIN="2";
//	
//	public static String ROOT="1";
}
