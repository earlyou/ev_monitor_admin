package com.finalproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.finalproject.vo.CarModelVO;
import com.finalproject.vo.ChargerVO;
import com.finalproject.vo.ChartVO;
import com.finalproject.vo.StationFareVO;
import com.finalproject.vo.UsersVO;

@Repository
@Mapper
public interface MainMapper {
	public List<UsersVO> searchcustomer(String str) throws Exception;
	public List<UsersVO> searchadmin(String str) throws Exception;
	public List<CarModelVO> searchev(String str) throws Exception;
	public List<StationFareVO> searchfare(String str) throws Exception;
	public List<ChargerVO> searchcharger(String str) throws Exception;
	
	public int getcustomercnt() throws Exception;
	public int getadmincnt() throws Exception;
	public int getchargercnt() throws Exception;
	public int getcarmodelcnt() throws Exception;
	public int getcommunitycnt() throws Exception;
	public int getstationcnt() throws Exception;
	
	public List<ChartVO> getmemberschartdata() throws Exception;
	
}
