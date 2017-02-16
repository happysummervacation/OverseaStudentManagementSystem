package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.FundingSourceDao;
import com.osms.entity.FundingSource;
import com.osms.utils.Packager;

@Repository("fundingSourceDao")
public class FundingSourceDaoImpl extends JDBCBase implements FundingSourceDao {

	@Override
	public FundingSource getFundingSourceByFundingSourceId(int fundingSourceId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		FundingSource fundingSource=null;
		String sql="SELECT * FROM FundingSource WHERE fundingSourceId="+fundingSourceId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				fundingSource=Packager.PAckagerFundingSource(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return fundingSource;
	}

	@Override
	public List<FundingSource> getAllFundingSource() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<FundingSource> fundingSources=new ArrayList<FundingSource>();
		String sql="SELECT * FROM FundingSource";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				fundingSources.add(Packager.PAckagerFundingSource(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return fundingSources;
	}

	@Override
	public void save(FundingSource fundingSource) {
		String sql="INSERT INTO FundingSource VLAUES(?)";
		Object[] param={
			fundingSource.getFundingSourceName()	
		};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void update(FundingSource fundingSource) {
		String sql="UPDATE FundingSource SET fundingSourceName=? WHERE fundingSourceId=?";
		Object[] parma={
			fundingSource.getFundingSourceName(),
			fundingSource.getFundingSourceId()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void delete(int fundingSourceId, String fundingSourceName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM FundingSource WHERE 1=1 ");
		try
		{
			if(fundingSourceId!=0)
			{
				sql.append(type+"fundingSourceId="+fundingSourceId+" ");
			}
			
			if(fundingSourceName!=null||!"".equals(fundingSourceName))
			{
				sql.append(type+" fundingSourceName="+fundingSourceName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
