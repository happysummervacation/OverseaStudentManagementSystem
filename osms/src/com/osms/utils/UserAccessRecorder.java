package com.osms.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.osms.globle.Constants;


public class UserAccessRecorder {

	// 登录页的访问次数
	private Integer INDEX_ACCESS_NUM = 0;
	// 用于存放页面访问次数和访问时间的HashMap集合
	private Map<String, String> accessMap = new HashMap<>();
	// 用于对Map集合进行时间正排序的ArrayList集合
	private ArrayList<Map.Entry<String, String>> accessList = null;

	/**
	 * 把Map对象放到List中，以时间字符串进行正排序
	 * @return 按时间正排序的List
	 */
	public List<Map.Entry<String, String>> getAccessList() {
		// 通过存放访问记录的Map的entry集合实例化ArrayList对象
		accessList = new ArrayList<>(accessMap.entrySet());
		/*
		 * 对该List集合进行排序 排序器比较器是一个匿名内部类 通过entry的时间字符串进行比较排序
		 */
		Collections.sort(accessList, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return accessList;
	}

	/**
	 * 记录访问页面的时间和次数
	 * @param page 访问页面的常数
	 */
	public void setAccessMap(String page) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 当前访问的是主页
		if (page.equals(Constants.LOGIN_PAGE))
			accessMap.put(page + ":" + ++INDEX_ACCESS_NUM, sdf.format(new Date()));
	}
}
