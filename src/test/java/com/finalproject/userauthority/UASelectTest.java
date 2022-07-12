package com.finalproject.userauthority;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.vo.UserAuthorityVO;

@SpringBootTest
class UASelectTest {
	
	@Autowired
	UserAuthorityBiz uabiz;
	
	@Test
	void contextLoads() {
		UserAuthorityVO userauthority = null;
		
		try {
			userauthority = uabiz.get(100);
			System.out.println(userauthority);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
