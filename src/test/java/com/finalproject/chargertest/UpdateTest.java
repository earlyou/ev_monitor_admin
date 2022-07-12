package com.finalproject.chargertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChargerBiz;
import com.finalproject.vo.ChargerVO;

@SpringBootTest
class UpdateTest {

	@Autowired
	ChargerBiz biz;
	
	@Test
	void contextLoads() {
		ChargerVO c = new ChargerVO(0, "test2", "test2", "test2", null, null, null);
		try {
			biz.modify(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
