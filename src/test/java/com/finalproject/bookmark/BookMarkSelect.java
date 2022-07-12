package com.finalproject.bookmark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.BookMarkBiz;
import com.finalproject.vo.BookMarkVO;
import com.finalproject.vo.UsersVO;

@SpringBootTest
class BookMarkSelect {
	
	@Autowired
	BookMarkBiz bbiz;
	
	@Test
	void contextLoads() {
		BookMarkVO bmu = null;
		
		try {
			bmu = bbiz.get(3);
			System.out.println(bmu);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
