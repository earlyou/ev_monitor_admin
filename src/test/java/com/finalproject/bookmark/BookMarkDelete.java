package com.finalproject.bookmark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.BookMarkBiz;

@SpringBootTest
class BookMarkDelete {
	
	@Autowired
	BookMarkBiz bbiz;
	
	@Test
	void contextLoads() {
		try {
			bbiz.remove(1);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
