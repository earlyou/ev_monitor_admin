package com.finalproject.carmodeltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.vo.CarModelVO;

@SpringBootTest
class DeleteTest {

	@Autowired
	CarModelBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(9999);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
