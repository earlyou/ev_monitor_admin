package com.finalproject.carmodeltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.vo.CarModelVO;

@SpringBootTest
class UpdateTest {

	@Autowired
	CarModelBiz biz;
	
	@Test
	void contextLoads() {
		CarModelVO c = new CarModelVO(9998, "test2", "test2", "test2", 0, 0, 0, 0);
		try {
			biz.modify(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
