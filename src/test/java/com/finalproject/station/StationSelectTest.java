package com.finalproject.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationBiz;
import com.finalproject.vo.StationVO;

@SpringBootTest
class StationSelectTest {
	
	@Autowired
	StationBiz sbiz;
	
	@Test
	void contextLoads() {
		StationVO st = null;
		
		try {
			st = sbiz.get(28260005);
			System.out.println(st);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
