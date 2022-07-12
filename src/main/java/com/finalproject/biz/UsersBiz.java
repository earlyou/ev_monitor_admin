package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.frame.Biz;
import com.finalproject.mapper.UsersMapper;
import com.finalproject.vo.UsersVO;

@Service
public class UsersBiz implements Biz<String, UsersVO>{

	@Autowired
	UsersMapper udao;
	
	@Override
	public void register(UsersVO v) throws Exception {
		udao.insert(v);
	}

	@Override
	public void modify(UsersVO v) throws Exception {
		udao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		udao.delete(k);
	}

	@Override
	public UsersVO get(String k) throws Exception {
		return udao.select(k);
	}

	@Override
	public List<UsersVO> get() throws Exception {
		return udao.selectall();
	}
	
	public int getCustomer() throws Exception {
		return udao.selectcustomer();
	}
	
	public List<UsersVO> getCustomerad() throws Exception {
		return udao.selectcustomerauthoritydetail();
	}
	

	
}
