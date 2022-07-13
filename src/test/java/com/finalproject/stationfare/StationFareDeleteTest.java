package com.finalproject.stationfare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationFareBiz;

@SpringBootTest
public class StationFareDeleteTest {

	@Autowired
	StationFareBiz stationfarebiz;
	
	@Test
	void contextLoads() {
		try {
			stationfarebiz.remove(2);
			System.out.println("delete Ok");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
