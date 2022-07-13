package com.finalproject.chgerstatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;

@SpringBootTest
class ChgerstatusDeleteTest {
	
	
	@Autowired
	ChgerstatusBiz ctbiz;
	
	@Test
	void contextLoads() {
		try {
			ctbiz.remove(02);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
