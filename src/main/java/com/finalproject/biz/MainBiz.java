package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.finalproject.mapper.MainMapper;
import com.finalproject.vo.UsersVO;

public class MainBiz {
	
	@Autowired
	MainMapper dao;
	
	public List<UsersVO> searchcustomer(String str) throws Exception {
		return dao.searchcustomer(str);	
	}
	
	public List<UsersVO> searchemployee(String str) throws Exception {
		return dao.searchmanager(str);	
	}
	
	public List<UsersVO> getManager() throws Exception {
		return dao.selectmanager();
	}

}
