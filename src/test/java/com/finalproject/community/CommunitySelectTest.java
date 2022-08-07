package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
class CommunitySelectTest {
	
	@Autowired
	CommunityBiz cmbiz;
	
	@Test
	void contextLoads() {
		CommunityVO review = null;
		
		try {
			review = cmbiz.get(5);
			System.out.println(review);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
