package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
public class CommunitySelectTest {

	@Autowired
	CommunityBiz commubiz;
	
	@Test
	void contextLoads() {
		CommunityVO cv = null;
		try {
			cv = commubiz.get(3);
			System.out.println(cv);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
	}
	
}
