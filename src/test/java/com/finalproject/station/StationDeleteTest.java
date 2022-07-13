package com.finalproject.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationBiz;

@SpringBootTest
class StationDeleteTest {
	
	
	@Autowired
	StationBiz sbiz;
	
	@Test
	void contextLoads() {
		try {
			sbiz.remove(28260005);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
