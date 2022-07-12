package com.finalproject.stationfare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationFareBiz;
import com.finalproject.vo.StationFareVO;

@SpringBootTest

public class StationFareSelectTest {

	@Autowired
	StationFareBiz stationfarebiz;
	
	@Test
	void contextLoads() {
		StationFareVO sfv = null;
		try {
			sfv = stationfarebiz.get(1);
			System.out.println(sfv);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
