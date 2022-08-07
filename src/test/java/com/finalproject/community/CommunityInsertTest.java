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
		CommunityVO review = new CommunityVO(5, "id02", "ME000016", "서울특별시 성북구", "여기 맨날 오는데", "저녁엔 한산함", "cimgname3", null);		
		try {
			cmbiz.register(review);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
