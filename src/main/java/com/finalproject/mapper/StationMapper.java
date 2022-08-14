package com.finalproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.finalproject.vo.StationVO;

@Repository
@Mapper
public interface StationMapper {
	public void insert(StationVO obj) throws Exception;
	public void delete(String obj) throws Exception;
	public void update(StationVO obj) throws Exception;
	public StationVO select(String obj) throws Exception;
	public List<StationVO> selectall() throws Exception;
	public void upsert(List<StationVO> list) throws Exception;
	
	public List<StationVO> searchstat(String search) throws Exception;
}
