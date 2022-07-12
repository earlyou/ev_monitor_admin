package com.finalproject.chargertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChargerBiz;

@SpringBootTest
class DeleteTest {

	@Autowired
	ChargerBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
