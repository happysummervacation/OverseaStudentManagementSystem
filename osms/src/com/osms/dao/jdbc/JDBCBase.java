package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author Administrator
 *
 */
public class JDBCBase {

	protected JDBCBase(){}
	
	/**
	 * 查询结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps)
	{
		return query(ps,null);
	}

	
	/**
	 * 封装未知参数并查询结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param parma 存放未知参数的数组
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps, Object[] parma)
	{
		return query(ps,parma,null,null);
	}
	
	
	/**
	 * 查询分页结果
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param start 起始索引
	 * @param maxCount 当页最大值
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps,Integer start,Integer maxCount)
	{
		return query(ps,null,start,maxCount);
	}

	
	/**
	 * 封装未知参数并查询分页结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param parma 存放未知参数的数组
	 * @param start 起始索引
	 * @param maxCount 当页最大值
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps, Object[] parma, Integer start, Integer maxCount)
	{
		ResultSet rs=null;
		
		try
		{
			if(parma!=null)
			{
				for(int i=0;i<parma.length;i++)
				{
					ps.setObject(i+1, parma[i]);
				}
			}
			
			//设置查询到的记录的最大索引
			if(start!=null&&maxCount!=null)
			{
				ps.setMaxRows(start+maxCount);
			}
			
			rs=ps.executeQuery();
			
			//设置查询到的记录的起始索引
			if(start!=null&&maxCount!=null)
			{
				rs.first();
				rs.relative(start-1);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	/**
	 * 非事务添加/更新操作
	 * @param sql sql语句
	 * @param parma 存放未知参数数组
	 * @return 添加操作的记录的id值
	 */
	protected int save(String sql,Object[] parma)
	{
		int id=-1;
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			//获取自动生成的键值
			ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(parma!=null)
			{
				for(int i=0;i<parma.length;i++)
				{
					ps.setObject(i+1, parma[i]);
				}
			}
			
			ps.executeUpdate();
			
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				//获取插入数据的主ID
				id=rs.getInt(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return id;
	}
	
	/**
	 * 事物添加
	 * @param sql
	 * 		sql语句
	 * @param parma
	 * 		未知类型的数据对象集合
	 * @param conn
	 * 		数据库链接对象
	 * @return
	 * 		添加操作记的记录的id值
	 */
	protected int save(String sql,Object[] parma,Connection conn)
	{
		int id=-1;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			//获取自动生成的键值
			ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(parma!=null)
			{
				for(int i=0;i<parma.length;i++)
				{
					ps.setObject(i+1, parma[i]);
				}
			}
			
			ps.executeUpdate();
			
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				//获取插入数据的主ID
				id=rs.getInt(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}finally
		{
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
		}
		
		return id;
	}
	
	
	protected int getCount(String sql)
	{
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int Count=0;
		
		try
		{
			ps=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=query(ps);
			if(rs.next())
			{
				Count=rs.getInt(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return Count;
	}
	
	
	/**
	 * 处理增、删、改操作
	 * @param sql sql语句
	 * @param value 代处理的值数组
	 */
	protected void saveOrUpdateOrDelete(String sql,Object value[])
	{
		PreparedStatement ps=null;
		Connection conn=JDBCUtil.getConnection();
		
		try
		{
			ps=conn.prepareStatement(sql);
			if(value!=null)
			{
				for(int i=0;i<value.length;i++)
				{
					System.out.println(i+" : "+value[i]);
					ps.setObject(i+1, value[i]);
				}
			}
			ps.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(null, ps, conn);
		}
	}
}
