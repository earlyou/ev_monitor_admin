package com.finalproject.community;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;

@SpringBootTest
class CommunitySelectAllTest {
	
	@Autowired
	CommunityBiz cmbiz;
	
	@Test
	void contextLoads() {
		List<CommunityVO> list = null;		
		try {
			list = cmbiz.get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (CommunityVO obj : list) {
			System.out.println(obj);
		}
	}

}
