package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.biz.StationBiz;
import com.finalproject.vo.StationVO;
import com.google.gson.Gson;

@RestController
public class AutocompleteController {
	
	@Autowired
	StationBiz sbiz;
	
	@RequestMapping("/autocomplete") // 커뮤니티 삭제
	public Object autocomplete(String searchValue, Model m) {
		
		Gson gson = new Gson();
		Object gsonlist = null;
  		try {
  			List<StationVO> list = sbiz.searchstat(searchValue);
  			gsonlist = gson.toJsonTree(list).toString();
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return gsonlist;
	}
}
