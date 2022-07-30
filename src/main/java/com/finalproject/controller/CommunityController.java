package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.vo.CommunityVO;
import com.finalproject.vo.StationFareVO;

@Controller
@RequestMapping("/cm")
public class CommunityController {
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	CommunityBiz combiz;
	
	@RequestMapping("select")
	public String select(Model m) {
		List<CommunityVO> list = null;
		try {
			list = combiz.get();
			m.addAttribute("comlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/cm/select");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, int pid) {
		
		CommunityVO review = null;
		try {
			review = combiz.get(pid);
			m.addAttribute("comp", review);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		m.addAttribute("center","/cm/detail");
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(int pid, Model m) {
		try {
			combiz.remove(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:select?pid="+pid;
	}

}
