package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.frame.Biz;
import com.finalproject.mapper.StationMapper;
import com.finalproject.vo.StationVO;

@Service
public class StationBiz implements Biz<String, StationVO>{

	@Autowired
	StationMapper sdao;

	@Override
	public void register(StationVO v) throws Exception {
		sdao.insert(v);
		
	}

	@Override
	public void modify(StationVO v) throws Exception {
		sdao.update(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		sdao.delete(k);
		
	}

	@Override
	public StationVO get(String k) throws Exception {
		return sdao.select(k);
	}

	@Override
	public List<StationVO> get() throws Exception {
		return sdao.selectall();
	}

	
	public List<StationVO> searchstat(String search) throws Exception{
		return sdao.searchstat(search);
	}

	
	
}
