package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.frame.Biz;
import com.finalproject.mapper.UserAuthorityMapper;
import com.finalproject.vo.UserAuthorityVO;

@Service
public class UserAuthorityBiz implements Biz<Integer,UserAuthorityVO> {

	@Autowired
	UserAuthorityMapper uadao;
	
	@Override
	public void register(UserAuthorityVO v) throws Exception {
		uadao.insert(v);
	}

	@Override
	public void modify(UserAuthorityVO v) throws Exception {
		uadao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		uadao.delete(k);
	}

	@Override
	public UserAuthorityVO get(Integer k) throws Exception {
		return uadao.select(k);
	}

	@Override
	public List<UserAuthorityVO> get() throws Exception {
		return uadao.selectall();
	}

}
