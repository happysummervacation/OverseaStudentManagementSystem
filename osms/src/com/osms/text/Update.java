package com.osms.text;

import org.junit.Test;

import com.osms.dao.jdbc.UserDaoImpl;
import com.osms.entity.Users;
import com.osms.utils.Utils;

public class Update {
	
	@Test
	public void update()
	{
		Users user=new Users();
		user.setUserId(4);
		user.setFullName("june");
		user.setGender(true);
		user.setTypeId(1);
		user.setPhone("17855832336");
		user.setEmail("123456@qq.com");
		user.setPassword(Utils.toMD5("123456"));
		user.setForeignIdentityId(4);
		user.setVisaId(4);
		user.setSchoolRollId(4);
		user.setStatus(1);
		
		UserDaoImpl u=new UserDaoImpl();
		u.update(user);
	}
	
}
