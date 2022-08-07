package com.finalproject.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class UsersCarSelectTest {
	
	@Autowired
	UsersBiz ubiz;
	
	@Test
	void contextLoads() {
		UsersVO users = null;
		
		try {
			users = ubiz.clpget("27아 5134");
			System.out.println(users);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
