package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.ClassDao;
import com.osms.entity.Class;
import com.osms.utils.Packager;

@Repository("classDao")
public class ClassDaoImpl extends JDBCBase implements ClassDao {

	@Override
	public Class getClassByclassId(int classId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Class cclass=null;
		String sql="SELECT * FROM Class WHERE classId="+classId;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				cclass=Packager.PackagerClass(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return cclass;
	}

	@Override
	public List<Class> getAllClass() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Class> classes=new ArrayList<Class>();
		String sql="SELECT * FROM Class";
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				classes.add(Packager.PackagerClass(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return classes;
	}

	@Override
	public void update(Class cclass) {
		StringBuilder sql=new StringBuilder("UPDATE Class SET className=?");
		ArrayList<Object> paramClass=new ArrayList<Object>();
		paramClass.add(cclass.getClassName());
		sql.append(" WHERE classId=?");
		paramClass.add(cclass.getClassId());
		Object[] param=paramClass.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
		
	}

	@Override
	public int save(Class cclass, Connection conn) {
		String sql="INSERT INTO Class VALUES(?,?,?)";
		Object[] param={
			cclass.getClassName()
		};
		int classId=save(sql, param, conn);
		return classId;
	}

	@Override
	public void delete(int classId, String className, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Class WHERE 1=1 ");
		try
		{
			if(classId!=0)
			{
				sql.append(type+"classId="+classId+" ");
			}
			
			if(className!=null||!"".equals(className))
			{
				sql.append(type+" className="+className+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
