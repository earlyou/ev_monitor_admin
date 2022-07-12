package com.finalproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.finalproject.vo.StationFareVO;

@Repository
@Mapper
public interface StationFareMapper {
	public void insert(StationFareVO stationfare) throws Exception;
	public void delete(int cid) throws Exception;
	public void update(StationFareVO stationfare) throws Exception;
	public StationFareVO select(int cid) throws Exception;
	public List <StationFareVO> selectall() throws Exception;
}
