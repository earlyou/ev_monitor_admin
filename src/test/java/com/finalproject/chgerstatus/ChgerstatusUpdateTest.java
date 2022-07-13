package com.finalproject.chgerstatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;
import com.finalproject.vo.ChgerstatusVO;

@SpringBootTest
class ChgerstatusUpdateTest {
	
	@Autowired
	ChgerstatusBiz ctbiz;
	
	@Test
	void contextLoads() {
		ChgerstatusVO obj = new ChgerstatusVO(02,28260005,
				2, "단독", 50, "20190829121020", "20220730121020", "20220920121020",
				"20221002131020", "Y", "고객 요구로 철거",03);
		try {
			ctbiz.modify(obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
