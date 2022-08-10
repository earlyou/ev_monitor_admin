package com.finalproject.station;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationBiz;
import com.finalproject.vo.StationVO;

@SpringBootTest
class StationUpdateTest {
	
	@Autowired
	StationBiz sbiz;
	
	@Test
	void contextLoads() {
		StationVO obj = new StationVO("28260005","기후대기관","인천광역시 서구 환경로 42","인천광역시", 
				28, 37.569620, 126.641973, "오전 6시 ~ 오후 10시 ", "무료","7/20 공사 예정", 
				"N","이유 없음", "ME","한국전력공사","한국자동차환경협회", "0000-0000");
		try {
			sbiz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
