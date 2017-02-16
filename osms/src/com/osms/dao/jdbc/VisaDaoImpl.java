package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.VisaDao;
import com.osms.entity.Visa;
import com.osms.utils.Packager;

@Repository("visaDao")
public class VisaDaoImpl extends JDBCBase implements VisaDao {

	@Override
	public Visa getVisaByVisaId(int visaId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Visa visa=null;
		String sql="SELECT * FROM Visa WHERE visaId="+visaId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				visa=Packager.PackagerVisa(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return visa;
	}

	@Override
	public List<Visa> getAllVisa() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Visa> visas=new ArrayList<Visa>();
		String sql="SELECT * FROM Visa";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				visas.add(Packager.PackagerVisa(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return visas;
	}

	@Override
	public int save(Visa visa, Connection conn) {
		String sql="INSERT INTO Visa VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] parma={
			visa.getRegisterDeadline(),
			visa.getIntermediary(),
			visa.getIntermediaryPhone(),
			visa.getGuaranteeName(),
			visa.getGuaranteePhone(),
			visa.getFundingSourceId(),
			visa.getPassportId(),
			visa.getApprovalTime(),
			visa.getVisaDueTime()
		};
		int visaId=save(sql, parma, conn);
		return visaId;
	}

	@Override
	public void update(Visa visa) {
		StringBuilder sql=new StringBuilder("UPDATE Visa SET fundingSourceId=?, passportId=?");
		ArrayList<Object> parmaVisa=new ArrayList<Object>();
		parmaVisa.add(visa.getFundingSourceId());
		parmaVisa.add(visa.getPassportId());
		
		if(visa.getRegisterDeadline()!=null||!"".equals(visa.getRegisterDeadline()))
		{
			sql.append(", registerDeadline=?");
			parmaVisa.add(visa.getRegisterDeadline());
		}
		
		if(visa.getIntermediary()!=null||!"".equals(visa.getIntermediary()))
		{
			sql.append(", intermediary=?");
			parmaVisa.add(visa.getIntermediary());
		}
		
		if(visa.getIntermediaryPhone()!=null||!"".equals(visa.getIntermediaryPhone()))
		{
			sql.append(", intermediaryPhone=?");
			parmaVisa.add(visa.getIntermediaryPhone());
		}
		
		if(visa.getGuaranteeName()!=null||!"".equals(visa.getGuaranteeName()))
		{
			sql.append(", guaranteeName=?");
			parmaVisa.add(visa.getGuaranteeName());
		}
		
		if(visa.getGuaranteePhone()!=null||!"".equals(visa.getGuaranteePhone()))
		{
			sql.append(", guaranteePhone=?");
			parmaVisa.add(visa.getGuaranteePhone());
		}
		
		if(visa.getApprovalTime()!=null||!"".equals(visa.getApprovalTime()))
		{
			sql.append(", approvalTime=?");
			parmaVisa.add(visa.getApprovalTime());
		}
		
		if(visa.getVisaDueTime()!=null||!"".equals(visa.getVisaDueTime()))
		{
			sql.append(", visaDueTime=?");
			parmaVisa.add(visa.getVisaDueTime());
		}
		
		sql.append(" WHERE visaId=?");
		parmaVisa.add(visa.getVisaId());
		Object[] parma=parmaVisa.toArray();
		saveOrUpdateOrDelete(sql.toString(), parma);
	}

	@Override
	public void delete(int visaId, int passportId, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Visa WHERE 1=1 ");
		try
		{
			if(visaId!=0)
			{
				sql.append(type+"visaId="+visaId+" ");
			}
			
			if(passportId!=0)
			{
				sql.append(type+"passportId="+passportId+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
