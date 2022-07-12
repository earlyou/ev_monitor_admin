package com.finalproject.stationfare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationFareBiz;
import com.finalproject.vo.StationFareVO;

@SpringBootTest

public class StationFareInsertTest {

	@Autowired
	StationFareBiz stationfarebiz;
	
	@Test
	void contextLoads() {
		// INSERT INTO stationfare VALUES (154,'EC', '이지차저', '완속', '회원', NULL, NULL, NULL, '180원');
		StationFareVO fv = new StationFareVO(155, "BN","블루네트웍스","급속","회원",null,null,"겨울(12~2월)","313원");
		try {
			stationfarebiz.register(fv);
			System.out.println("register OK");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
