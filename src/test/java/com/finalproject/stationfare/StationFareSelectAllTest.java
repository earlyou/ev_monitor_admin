package com.finalproject.stationfare;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.StationFareBiz;
import com.finalproject.vo.StationFareVO;

@SpringBootTest

public class StationFareSelectAllTest {

	@Autowired
	StationFareBiz stationfarebiz;
	
	@Test
	void contextLoads() {
		List<StationFareVO> list = null;
		try {
			list = stationfarebiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(StationFareVO obj : list) {
			System.out.println(obj);
		}
	
	}
}
