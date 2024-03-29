package com.finalproject.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.frame.Biz;
import com.finalproject.mapper.CarModelMapper;
import com.finalproject.vo.CarModelVO;

@Service
public class CarModelBiz implements Biz<Integer, CarModelVO> {

	@Autowired
	CarModelMapper dao;
	
	@Override
	public void register(CarModelVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(CarModelVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public CarModelVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CarModelVO> get() throws Exception {
		return dao.selectall();
	}

}
