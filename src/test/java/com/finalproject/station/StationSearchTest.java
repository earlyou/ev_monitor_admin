package com.finalproject.station;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationBiz;
import com.finalproject.vo.StationVO;

@SpringBootTest
class StationSearchTest {
	
	@Autowired
	StationBiz sbiz;
	
	@Test
	void contextLoads() {
		List<StationVO> list = null;
		try {
			list = sbiz.searchstat("강남대로");
			for (StationVO s : list) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
