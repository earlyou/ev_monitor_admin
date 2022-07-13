package com.finalproject.community;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
public class CommunityInsertTest {

	@Autowired
	CommunityBiz commubiz;
	
	@Test
	void contextLoads() {
		
// int pid, String uid, int statId, String tf, String cimgname,sysdate() int zcode, String statnm
		CommunityVO cv = new CommunityVO(60,"id10",55,"테스트","img",null,11,"세종로공영주차장2");
		try {
			commubiz.register(cv);
			System.out.println("register Ok");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}


}
