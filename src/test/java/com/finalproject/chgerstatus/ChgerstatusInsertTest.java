package com.finalproject.chgerstatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;

@SpringBootTest
class ChgerstatusInsertTest {
	
	@Autowired
	ChgerstatusBiz ctbiz;
	
	@Test
	void contextLoads() {
//		ChgerstatusVO st = new ChgerstatusVO(02,28260005,
//				2, "단독", 50, "20190829121020", "20210801121020", "20210801121020",
//				"20210802131020", "Y", "고객 요구로 철거",03);		
//		try {
//			ctbiz.register(st);
//			System.out.println("Register OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
