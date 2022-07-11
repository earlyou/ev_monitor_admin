package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.mapper.MainMapper;
import com.finalproject.vo.UsersVO;

@Service
public class MainBiz {
	
	@Autowired
	MainMapper dao;
	
	public List<UsersVO> searchcustomer(String str) throws Exception {
		return dao.searchcustomer(str);	
	}
	
	public List<UsersVO> searchemployee(String str) throws Exception {
		return dao.searchmanager(str);	
	}
	
	public int getCustomerCnt() throws Exception {
		return dao.getcustomercnt();
	}
	
	public int getManagerCnt() throws Exception {
		return dao.getmanagercnt();
	}
}
