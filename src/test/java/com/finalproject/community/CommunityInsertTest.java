package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
class CommunityInsertTest {

	@Autowired
	CommunityBiz cmbiz;
	
	@Test
	void contextLoads() {
		CommunityVO review = new CommunityVO(4, "id02", "ME000025", "충전기 추가 필요","cimgname4", null);		
		try {
			cmbiz.register(review);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
