package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.NoticeDao;
import com.osms.entity.Notice;
import com.osms.utils.Packager;

@Repository("noticeDao")
public class NoticeDaoImpl extends JDBCBase implements NoticeDao {

	@Override
	public Notice getNoticeByNoticeId(int noticeId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Notice notice=null;
		String sql="SELECT * FROM Notice WHERE noticeId="+noticeId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				notice=Packager.PackagerNotice(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return notice;
	}

	@Override
	public List<Notice> getAllNotice() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> notices=new ArrayList<Notice>();
		String sql="SELECT * FROM Notice";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				notices.add(Packager.PackagerNotice(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return notices;
	}

	@Override
	public void save(Notice notice) {
		String sql="INSERT INTO Notice VALUES(?,?,?,?,?,?,?,?)";
		Object[] parma={
			notice.getTitle(),
			notice.getContent(),
			notice.getWriter(),
			notice.getUserId(),
			notice.getNoticeId(),
			notice.getDownLoadPath(),
			notice.getPublishTime(),
			notice.getStatus()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void update(Notice notice) {
		StringBuilder sql=new StringBuilder("UPDATE Notice SET userId=?, noticeTypeId=?, status=?");
		ArrayList<Object> parmaNotice=new ArrayList<Object>();
		parmaNotice.add(notice.getUserId());
		parmaNotice.add(notice.getNoticeTypeId());
		parmaNotice.add(notice.getStatus());
		
		if(notice.getTitle()!=null||!"".equals(notice.getTitle()))
		{
			sql.append(", title=?");
			parmaNotice.add(notice.getTitle());
		}
		
		if(notice.getContent()!=null||!"".equals(notice.getContent()))
		{
			sql.append(", content=?");
			parmaNotice.add(notice.getContent());
		}
		
		if(notice.getWriter()!=null||!"".equals(notice.getWriter()))
		{
			sql.append(", writer=?");
			parmaNotice.add(notice.getWriter());
		}
		
		if(notice.getDownLoadPath()!=null||!"".equals(notice.getDownLoadPath()))
		{
			sql.append(", downLoadPath=?");
			parmaNotice.add(notice.getDownLoadPath());
		}
		
		if(notice.getPublishTime()!=null||!"".equals(notice.getPublishTime()))
		{
			sql.append(", publishTime=?");
			parmaNotice.add(notice.getPublishTime());
		}
		
		sql.append(" WHERE noticeId=?");
		parmaNotice.add(notice.getNoticeId());
		Object[] parma=parmaNotice.toArray();
		saveOrUpdateOrDelete(sql.toString(), parma);
	}

	@Override
	public void delete(int noticeId, int userId, int noticeTypeId, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Notice WHERE 1=1 ");
		try
		{
			if(noticeId!=0)
			{
				sql.append(type+"noticeId="+noticeId+" ");
			}
			
			if(userId!=0)
			{
				sql.append(type+"userId="+userId+" ");
			}
			
			if(noticeTypeId!=0)
			{
				sql.append(type+"noticeTypeId="+noticeTypeId+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
