package com.finalproject.bookmark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.BookMarkBiz;
import com.finalproject.vo.BookMarkVO;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class BookMarkInsert {
	
	@Autowired
	BookMarkBiz bbiz;
	
	@Test
	void contextLoads() {
		BookMarkVO bm = new BookMarkVO(04, 05,"id04",42,"강원도");		
		try {
			bbiz.register(bm);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
