package com.finalproject.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class UsersUpdateTest {
	
	@Autowired
	UsersBiz biz;
	
	@Test
	void contextLoads() {
		UsersVO obj = new UsersVO("id7508","pwd7508*","김현재","khj590","010-2156-5098","khj@naver.com","12마 5816", 100, null, 101);
		
		try {
			biz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
