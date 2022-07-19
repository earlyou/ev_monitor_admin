package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.ChargerBiz;
import com.finalproject.frame.Util;
import com.finalproject.vo.ChargerVO;


@Controller
@RequestMapping("/ct")
public class ChargerController {
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	ChargerBiz cbiz;
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center", "/ct/add");
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model m, ChargerVO c) {
		
		String pinimg = c.getMf().getOriginalFilename();
		c.setPinimg(pinimg);
		
		try {
			cbiz.register(c);
			Util.saveFile(c.getMf(),admindir,userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/ct/detail");
		return "redirect:select";
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		List<ChargerVO> list = null;
		try {
			list = cbiz.get();
			m.addAttribute("clist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/ct/select");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, int ptid) {
		ChargerVO obj = null;
		try {
			obj = cbiz.get(ptid);
			m.addAttribute("cpt", obj);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		m.addAttribute("center","/ct/detail");
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model m, ChargerVO o) {
		
		String pinname = o.getMf().getOriginalFilename();
		if(!(pinname.equals(""))){
			o.setPinimg(pinname);
			Util.saveFile(o.getMf(),admindir,userdir);
		}	
		
		try {
			cbiz.modify(o);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return "redirect:detail?ptid="+o.getPtid();
	}
	
	@RequestMapping("/delete")
	public String delete(int ptid, Model m) {
		try {
			cbiz.remove(ptid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:select?ptid="+ptid;
	}
}
