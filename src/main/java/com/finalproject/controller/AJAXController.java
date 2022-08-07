package com.finalproject.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.biz.MainBiz;
import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.ChartVO;
import com.finalproject.vo.UsersVO;

@RestController
public class AJAXController {
	
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	MainBiz mbiz;
	
	@RequestMapping("checkid")
	public String checkid(String id) {		
		String result = "";
		UsersVO uvo = null;
		
		if(!Pattern.matches("^[0-9a-zA-Z]*$",id)) { 
			return "2"; 
		}		
		try {
			uvo = ubiz.get(id);
			if(uvo == null) {
				result = "0";
			}else{
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	@RequestMapping("checkclp") // 번호판 검사
	public String checkclp(String clp) {		
		String result = "";
		UsersVO uvo = null;
						
		try {
			uvo = ubiz.clpget(clp);
			if(uvo == null) {
				result = "0";
			}else{
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	@RequestMapping("custregchartimpl")
	public Object custregchartimpl(Model m) {
		
		JSONObject jo = new JSONObject();
		JSONArray userautharr100 = new JSONArray();
		JSONArray userautharr200 = new JSONArray();
		JSONArray evcdatearr = new JSONArray();
		
		List<ChartVO> clist = null;
		
		try {
			clist=mbiz.getmemberschartdata();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ChartVO c :clist) {
			userautharr100.add(c.getUA100members());
			userautharr200.add(c.getUA200members());
			evcdatearr.add(c.getEvcdate());
		}
		
		jo.put("userautharr100", userautharr100);
		jo.put("userautharr200", userautharr200);
		jo.put("evcdatearr", evcdatearr);
		return jo;
	}

}
