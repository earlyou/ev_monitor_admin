package com.finalproject.userauthority;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.vo.UserAuthorityVO;

@SpringBootTest
class UAInsertTest {
	
	@Autowired
	UserAuthorityBiz uabiz;
	
	@Test
	void contextLoads() {
		UserAuthorityVO userauthority = new UserAuthorityVO(300,"직원");		
		try {
			uabiz.register(userauthority);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
