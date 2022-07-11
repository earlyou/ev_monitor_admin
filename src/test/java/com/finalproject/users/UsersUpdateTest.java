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
		UsersVO obj = new UsersVO("id04","pwd04","김영미","kym58","010-5489-1245","kym@naver.com","31나 5816",100,null,04);
		
		try {
			biz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
