package com.osms.dao.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 数据库连接静态类
 * @author Administrator
 *
 */
public class JDBCUtil {

	
	private static String name=null;//连接字符串
	private static String url=null;//数据库url地址
	private static String user=null;//数据库链接用户名
	private static String password=null;//数据库连接密码
	
	
	/**
	 * 加载jdbc参数
	 */
	static
	{
		loadProperties();
		try 
		{
			Class.forName(name);
		} catch (ClassNotFoundException e)
		{
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 载入数据库链接参数
	 */
	private static void loadProperties()
	{
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath()
					+"jdbc.properties"));
			name=prop.getProperty("driverClassName");
			url=prop.getProperty("url");
			user=prop.getProperty("username");
			password=prop.getProperty("password");
		} catch (IOException e)
		{
			System.out.println("数据库参数加载错误");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 建立数据库连接
	 * @return 返回Connection对象
	 */
	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e)
		{
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 关闭数据库对象连接
	 * @param rs 关闭ResultSet
	 * @param stmt 关闭Statement
	 * @param conn 关闭Connection
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn)
	{
		try 
		{
			if(rs!=null)
			{
				rs.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(stmt!=null)
			{
				stmt.close();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(conn!=null)
			{
				conn.close();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据对象类型关闭数据库连接
	 * @param o
	 */
	public static void close(Object o)
	{
		try
		{
			if(o instanceof ResultSet)
			{
				((ResultSet) o).close();
			}else if(o instanceof Statement)
			{
				((Statement) o).close();
			}else if(o instanceof Connection)
			{
				((Connection) o).close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 关闭ResultSet
	 * @param resultSets
	 */
	public static void close(ResultSet...resultSets)
	{
		for(ResultSet rs:resultSets)
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 打印结果集
	 * @param rs
	 */
	public static void printResultSet(ResultSet rs)
	{
		StringBuffer sb=new StringBuffer();
		try
		{
			ResultSetMetaData meta=rs.getMetaData();
			int clos=meta.getColumnCount();
			while(rs.next())
			{
				for(int i=1;i<clos;i++)
				{
					sb.append(meta.getColumnName(i)+"=");
					sb.append(rs.getString(i)+"  ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
