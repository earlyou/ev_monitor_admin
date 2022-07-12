package com.finalproject.bookmark;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.BookMarkBiz;
import com.finalproject.vo.BookMarkVO;

@SpringBootTest
class BookMarkSelectAll {
	
	@Autowired
	BookMarkBiz bbiz;
	
	@Test
	void contextLoads() {
		List<BookMarkVO> list = null;		
		try {
			list = bbiz.get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (BookMarkVO obj : list) {
			System.out.println(obj);
		}
	}


}
