package com.finalproject.carmodeltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.vo.CarModelVO;

@SpringBootTest
class SelectTest {

	@Autowired
	CarModelBiz biz;
	
	@Test
	void contextLoads() {
		CarModelVO c = null;
		try {
			c = biz.get(9998);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
