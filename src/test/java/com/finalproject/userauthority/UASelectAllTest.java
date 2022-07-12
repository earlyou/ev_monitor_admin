package com.finalproject.userauthority;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.vo.UserAuthorityVO;

@SpringBootTest
class UASelectAllTest {

	@Autowired
	UserAuthorityBiz uabiz;
	
	@Test
	void contextLoads() {
		List<UserAuthorityVO> list = null;
		
		try {
			list = uabiz.get();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserAuthorityVO obj : list) {
			System.out.println(obj);
		}
	}
}
