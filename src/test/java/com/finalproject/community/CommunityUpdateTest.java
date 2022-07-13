package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
public class CommunityUpdateTest {

	@Autowired
	CommunityBiz commubiz;
	
	@Test
	void contextLoads() {
		
		//text=#{tf}, cimgname=#{cimgname},statnm=#{statnm} WHERE pid=#{pid}
		CommunityVO obj = new CommunityVO("테스트텍스트","테스트이미지","종묘공영주차장2");
		try {
			commubiz.modify(obj);
			System.out.println("Updated OK");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
