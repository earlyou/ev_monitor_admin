package com.finalproject.chargertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChargerBiz;
import com.finalproject.vo.ChargerVO;

@SpringBootTest
class InsertTest {

	@Autowired
	ChargerBiz biz;
	
	@Test
	void contextLoads() {
		ChargerVO c = new ChargerVO(0, "test", "test", "test", null, null, null);
		try {
			biz.register(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
