package com.finalproject.chgerstatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;
import com.finalproject.vo.ChgerstatusVO;

@SpringBootTest
class ChgerstatusSelectTest {
	
	@Autowired
	ChgerstatusBiz ctbiz;
	
	@Test
	void contextLoads() {
		ChgerstatusVO cst = null;
		
		try {
			cst = ctbiz.get(02);
			System.out.println(cst);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
