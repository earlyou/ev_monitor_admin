package com.finalproject.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class UsersInsertTest {

	@Autowired
	UsersBiz ubiz;
	
	@Test
	void contextLoads() {
		UsersVO users = new UsersVO("id04","pwd04","최영미","cym58","010-5462-4861","cym@naver.com","35나 2626",100,null,04);		
		try {
			ubiz.register(users);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
