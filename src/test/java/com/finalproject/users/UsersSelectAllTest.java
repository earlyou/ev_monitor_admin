package com.finalproject.users;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class UsersSelectAllTest {
	
	@Autowired
	UsersBiz ubiz;
	
	@Test
	void contextLoads() {
		List<UsersVO> list = null;		
		try {
			list = ubiz.get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (UsersVO obj : list) {
			System.out.println(obj);
		}
	}

}
