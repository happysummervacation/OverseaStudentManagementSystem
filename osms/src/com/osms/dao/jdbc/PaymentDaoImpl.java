package com.osms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osms.dao.PaymentDao;
import com.osms.entity.Payment;
import com.osms.utils.Packager;

@Repository("paymentDao")
public class PaymentDaoImpl extends JDBCBase implements PaymentDao {

	@Override
	public Payment getPaymentByPaymentId(int paymentId) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Payment payment=null;
		String sql="SELECT * FROM Payment WHERE paymentId="+paymentId;
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				payment=Packager.PackagerPayment(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return payment;
	}

	@Override
	public List<Payment> getAllPayment() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Payment> payments=new ArrayList<Payment>();
		String sql="SELECT * FROM Payment";
		try {
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				payments.add(Packager.PackagerPayment(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return payments;
	}

	@Override
	public void save(Payment payment) {
		String sql="INSERT INTO Payment VALUES(?,?,?,?,?,?,?)";
		Object[] parma={
			payment.getUserId(),
			payment.getPaymentTypeId(),
			payment.getMoney(),
			payment.getPayTime(),
			payment.isDone(),
			payment.getDescription(),
			payment.getStatus()
		};
		saveOrUpdateOrDelete(sql, parma);
	}

	@Override
	public void update(Payment payment) {
		StringBuilder sql=new StringBuilder("UPDATE Payment SET isDone=?, status=?");
		ArrayList<Object> parmaPayment=new ArrayList<Object>();
		parmaPayment.add(payment.isDone());
		parmaPayment.add(payment.getStatus());
		
		if(payment.getUserId()!=0)
		{
			sql.append(", userId=?");
			parmaPayment.add(payment.getUserId());
		}
		
		if(payment.getPaymentTypeId()!=0)
		{
			sql.append(", paymentTypeId=?");
			parmaPayment.add(payment.getPaymentTypeId());
		}
		
		if(payment.getMoney()!=0)
		{
			sql.append(", money=?");
			parmaPayment.add(payment.getMoney());
		}
		
		if(payment.getPayTime()!=null||!"".equals(payment.getPayTime()))
		{
			sql.append(", payTime=?");
			parmaPayment.add(payment.getPayTime());
		}
		
		if(payment.getDescription()!=null||!"".equals(payment.getDescription()))
		{
			sql.append(", description=?");
			parmaPayment.add(payment.getDescription());
		}
		Object[] parma=parmaPayment.toArray();
		saveOrUpdateOrDelete(sql.toString(), parma);
	}

	@Override
	public void delete(int paymentId, int userId, int paymentTypeId, String type) {
		StringBuilder sql=new StringBuilder("DELETE FROM Payment WHERE 1=1 ");
		try
		{
			if(paymentId!=0)
			{
				sql.append(type+"paymentId="+paymentId+" ");
			}
			
			if(userId!=0)
			{
				sql.append(type+"userId="+userId+" ");
			}
			
			if(paymentTypeId!=0)
			{
				sql.append(type+"paymentTypeId="+paymentTypeId+" ");
			}
			
			saveOrUpdateOrDelete(sql.toString(), null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
