package com.finalproject.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UsersBiz;

@SpringBootTest
class UsersDeleteTest {
	
	@Autowired
	UsersBiz ubiz;
	
	@Test
	void contextLoads() {
		try {
			ubiz.remove("id03");
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
