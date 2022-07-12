package com.finalproject.userauthority;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.vo.UserAuthorityVO;

@SpringBootTest
class UAUpdateTest {
	
	@Autowired
	UserAuthorityBiz uabiz;
	
	@Test
	void contextLoads() {
		UserAuthorityVO obj = new UserAuthorityVO(300,"실버");
		
		try {
			uabiz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
