package com.osms.globle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.osms.utils.UserAccessRecorder;


/**
 * 全局变量，用于记录用户访问记录
 */
public class Globle {

	// 用于存放用户访问记录器的Map集合
	private static Map<Integer, UserAccessRecorder> userAccessMap = new HashMap<>();

	/**
	 * 添加用户访问记录
	 * @param uid 用户id
	 * @param page 访问页面
	 */
	public static void addAccessRecord(Integer uid, String page) {
		UserAccessRecorder recorder = Globle.userAccessMap.get(uid);
		if (recorder == null) {
			Globle.userAccessMap.put(uid, new UserAccessRecorder());
			recorder = Globle.userAccessMap.get(uid);
		}
		recorder.setAccessMap(page);
	}

	/**
	 * 清除用户访问记录
	 * @param uid 用户id
	 */
	public static void clearAccessRecorder(Integer uid) {
		Globle.userAccessMap.remove(uid);
	}

	/**
	 * 获取用户访问列表（按时间正序排列）
	 * @param uid 用户id
	 * @return 访问记录列表
	 */
	public static List<Map.Entry<String, String>> getAccessList(Integer uid) {
		UserAccessRecorder recorder = Globle.userAccessMap.get(uid);
		if (recorder == null) {
			Globle.userAccessMap.put(uid, new UserAccessRecorder());
			recorder = Globle.userAccessMap.get(uid);
		}
		return recorder.getAccessList();
	}
	

	/**
	 * 设置map集合，存放用户已登录的session信息 Map泛型String代表不同用户的标识符userId
	 * Map的泛型HttpSession代表当前用户的会话
	 */
	public static Map<String, HttpSession> loginSessionMap = new HashMap<String, HttpSession>();
}
