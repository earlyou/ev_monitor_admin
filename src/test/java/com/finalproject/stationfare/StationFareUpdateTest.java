package com.finalproject.stationfare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationFareBiz;
import com.finalproject.vo.StationFareVO;

@SpringBootTest
public class StationFareUpdateTest {

	@Autowired
	StationFareBiz stationfarebiz;
	
	@Test
	void contextLoads() {
		//(int cid, String busiId, String bnm, String cs, String time, String seasons, String cf)
		StationFareVO obj = new StationFareVO(5, "ME","환경부","초급속","회원", "Y", "경부하", "봄(3~5월)","320원");
		try {
			stationfarebiz.modify(obj);
			System.out.println("Updated Ok");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
