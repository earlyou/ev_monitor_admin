package com.finalproject.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationBiz;
import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.vo.StationVO;
import com.finalproject.vo.UserAuthorityVO;

@SpringBootTest
class StationInsertTest {
	
	@Autowired
	StationBiz sbiz;
	
	@Test
	void contextLoads() {
		StationVO st = new StationVO("28260005","기후대기관","인천광역시 서구 환경로 42","인천광역시", 28, 37.569620, 126.641973, "24시간 이용가능", "무료","7/18 공사 예정", "N","이유 없음", "ME","한국전력공사","한국자동차환경협회", "1644-9408");		
		try {
			sbiz.register(st);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
