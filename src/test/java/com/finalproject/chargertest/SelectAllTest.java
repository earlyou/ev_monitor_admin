package com.finalproject.chargertest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChargerBiz;
import com.finalproject.vo.ChargerVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	ChargerBiz biz;
	
	@Test
	void contextLoads() {
		try {
		List<ChargerVO> list = biz.get();
			for (ChargerVO c : list) {				
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
