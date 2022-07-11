package com.finalproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.finalproject.vo.UsersVO;

@Repository
@Mapper
public interface MainMapper {
	public List<UsersVO> searchcustomer(String str) throws Exception;
	public List<UsersVO> searchmanager(String str) throws Exception;
	public List<UsersVO> selectmanager() throws Exception;
}
