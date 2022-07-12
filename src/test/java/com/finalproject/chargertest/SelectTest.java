package com.finalproject.chargertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChargerBiz;
import com.finalproject.vo.ChargerVO;

@SpringBootTest
class SelectTest {

	@Autowired
	ChargerBiz biz;
	
	@Test
	void contextLoads() {
		ChargerVO c = null;
		try {
			c = biz.get(1);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
