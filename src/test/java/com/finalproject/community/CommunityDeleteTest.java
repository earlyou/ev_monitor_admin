package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;

@SpringBootTest
class CommunityDeleteTest {
	
	@Autowired
	CommunityBiz cmbiz;
	
	@Test
	void contextLoads() {
		try {
			cmbiz.remove(5);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
