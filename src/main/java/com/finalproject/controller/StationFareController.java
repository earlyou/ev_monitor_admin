package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.StationFareBiz;
import com.finalproject.vo.StationFareVO;

@Controller
@RequestMapping("/sf")
public class StationFareController {
	
	@Autowired
	StationFareBiz sfbiz;
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center", "/sf/add");
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model m, StationFareVO s) {
		
		try {
			sfbiz.register(s);
			m.addAttribute("cstationfare", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/sf/detail");
		return "redirect:select";
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		List<StationFareVO> list = null;
		try {
			list = sfbiz.get();
			m.addAttribute("sflist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/sf/select");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, int cid) {
		StationFareVO obj = null;
		try {
			obj = sfbiz.get(cid);
			m.addAttribute("sf", obj);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		m.addAttribute("center","/sf/detail");
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model m, StationFareVO stationfare) {
		
		try {
			sfbiz.modify(stationfare);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return "redirect:detail?cid="+stationfare.getCid();
	}
	
	@RequestMapping("/delete")
	public String delete(int cid, Model m) {
		try {
			sfbiz.remove(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:select?cid="+cid;
	}

}
