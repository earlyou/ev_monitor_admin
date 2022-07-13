package com.finalproject.chgerstatus;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;
import com.finalproject.vo.ChgerstatusVO;

@SpringBootTest
class ChgerstatusSelectAllTest {

	@Autowired
	ChgerstatusBiz ctbiz;
	
	@Test
	void contextLoads() {
		List<ChgerstatusVO> list = null;
		
		try {
			list = ctbiz.get();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ChgerstatusVO obj : list) {
			System.out.println(obj);
		}
	}
}
