package com.finalproject.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.MainBiz;

@SpringBootTest
class ManagerCntTest {

	@Autowired
	MainBiz biz;
	
	@Test
	void contextLoads() {
		int count;
		try {
			count = biz.getManagerCnt();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
