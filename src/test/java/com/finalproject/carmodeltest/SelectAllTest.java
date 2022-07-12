package com.finalproject.carmodeltest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.vo.CarModelVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	CarModelBiz biz;
	
	@Test
	void contextLoads() {
		try {
		List<CarModelVO> list = biz.get();
			for (CarModelVO c : list) {				
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
