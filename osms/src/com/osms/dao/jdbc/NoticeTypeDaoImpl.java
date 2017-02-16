package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.NoticeTypeDao;
import com.osms.entity.NoticeType;
import com.osms.utils.Packager;

@Repository("noticeTypeDao")
public class NoticeTypeDaoImpl extends JDBCBase implements NoticeTypeDao {

	@Override
	public NoticeType getNoticeTypeByNoticeTypeId(int noticeTypeId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		NoticeType noticeType=null;
		String sql="SELECT * FROM NoticeType WHERE noticeTypeId="+noticeTypeId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				noticeType=Packager.PackagerNoticeType(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return noticeType;
	}

	@Override
	public List<NoticeType> getAllNoticeType() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<NoticeType> noticeTypes=new ArrayList<NoticeType>();
		String sql="SELECT * FROM NoticeType";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				noticeTypes.add(Packager.PackagerNoticeType(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return noticeTypes;
	}

	@Override
	public void save(NoticeType noticeType) {
		String sql="INSERT INTO NoticeType VALUES(?)";
		Object[] parma={
			noticeType.getNoticeTypeName()	
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void update(NoticeType noticeType) {
		String sql="UPDATE NoticeType SET noticeTypeName=? WHERE noticeTypeId=?";
		Object[] parma={
			noticeType.getNoticeTypeName(),
			noticeType.getNoticeTypeId()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void delete(int noticeTypeId, String noticeTypeName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM NoticeType WHERE 1=1 ");
		try
		{
			if(noticeTypeId!=0)
			{
				sql.append(type+"noticeTypeId="+noticeTypeId+" ");
			}
			
			if(noticeTypeName!=null||!"".equals(noticeTypeName))
			{
				sql.append(type+" noticeTypeName="+noticeTypeName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
