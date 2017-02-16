package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.PaymentTypeDao;
import com.osms.entity.PaymentType;
import com.osms.utils.Packager;

@Repository("paymentTypeDao")
public class PaymentTypeDaoImpl extends JDBCBase implements PaymentTypeDao {

	@Override
	public PaymentType getPaymentTypeByPaymentTypeId(int paymentTypeId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PaymentType paymentType=null;
		String sql="SELECT * FROM PaymentType WHERE paymentTypeId="+paymentTypeId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				paymentType=Packager.PackagerPaymentType(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return paymentType;
	}

	@Override
	public List<PaymentType> getAllPaymentType() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<PaymentType> paymentTypes=new ArrayList<PaymentType>();
		String sql="SELECT * FROM PaymentType";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				paymentTypes.add(Packager.PackagerPaymentType(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return paymentTypes;
	}

	@Override
	public void save(PaymentType paymentType) {
		String sql="INSERT INTO PaymentType VALUES(?)";
		Object[] parma={
			paymentType.getPaymentTypeName()	
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void update(PaymentType paymentType) {
		String sql="UPDATE PaymentType SET paymentTypeName=? WHERE paymentTypeId=?";
		Object[] parma={
			paymentType.getPaymentTypeName(),
			paymentType.getPaymentTypeId()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void delete(int paymentTypeId, String paymentTypeName, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM PaymentType WHERE 1=1 ");
		try
		{
			if(paymentTypeId!=0)
			{
				sql.append(type+"paymentTypeId="+paymentTypeId+" ");
			}
			
			if(paymentTypeName!=null||!"".equals(paymentTypeName))
			{
				sql.append(type+" paymentTypeName="+paymentTypeName+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
