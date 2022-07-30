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
		CommunityVO obj = new CommunityVO(3, "id05", "ME000017", "충전기 추가 배치, 정보 상이", "cimgname3",null);
		
		try {
			cmbiz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
