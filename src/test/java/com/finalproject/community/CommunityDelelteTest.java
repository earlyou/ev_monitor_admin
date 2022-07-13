package com.finalproject.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.CommunityBiz;

@SpringBootTest
public class CommunityDelelteTest {
@Autowired
CommunityBiz commubiz;

@Test
void contextLoads() {
	try {
		commubiz.remove(2);
		System.out.println("delete ok");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
