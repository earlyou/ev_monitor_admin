package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
class CommunityUpdateTest {
	
	@Autowired
	CommunityBiz cmbiz;
	
	@Test
	void contextLoads() {
		CommunityVO obj = new CommunityVO(5, "id02", "ME000016", "서울특별시 성북구", "충전기 추가 배치 정보 상이", "시설이 깨끗하네요.", "cimgname4", null);
		
		try {
			cmbiz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
