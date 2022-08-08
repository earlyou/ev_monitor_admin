package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.finalproject.biz.CommunityBiz;
import com.finalproject.biz.UsersBiz;
import com.finalproject.frame.Util;
import com.finalproject.vo.CommunityVO;

@Controller
@RequestMapping("/cm")
public class CommunityController {
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	CommunityBiz commubiz;
	
	@Autowired
	UsersBiz ubiz;
	
	@RequestMapping("select")
	public String select(Model m) {
		List<CommunityVO> list = null;
		try {
			list = commubiz.get();
			m.addAttribute("postlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/cm/select");
		
		return "main";
	}
	

	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center", "/cm/add");
		return "main";
	}
	
	@RequestMapping("/addimpl")
	public String addimpl(Model m, CommunityVO commu) {
		
		String cimgname = ((MultipartFile) commu.getMf()).getOriginalFilename();
		commu.setCimgname(cimgname);
		try {
			commubiz.register(commu);
			Util.saveFile((MultipartFile) commu.getMf(), admindir, userdir);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:select";
	}
	

	@RequestMapping("/detail")
	public String detail(Model m, int pid) {
		CommunityVO review = null;
	
			try {
				review = commubiz.get(pid);
				m.addAttribute("comp", review);
			} catch (Exception e) {				
				e.printStackTrace();
			}
			m.addAttribute("center", "/cm/detail");
		return "main";
	
	}
	
	@RequestMapping("/update")
	public String update(Model m, CommunityVO commu) {
		
		String cimgname = ((MultipartFile) commu.getMf()).getOriginalFilename();
		if(!(cimgname.equals(""))){
			commu.setCimgname(cimgname);
			Util.saveFile((MultipartFile) commu.getMf(),admindir,userdir);
		}	
		
		try {
			commubiz.modify(commu);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return "redirect:detail?postid="+commu.getPid();
	}
	
	@RequestMapping("/delete")
	public String delete(int pid, Model m) {
		try {
			commubiz.remove(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:select?pid="+pid;
	}
	}



