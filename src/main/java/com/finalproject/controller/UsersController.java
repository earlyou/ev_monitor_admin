package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.biz.UserAuthorityBiz;
import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.CarModelVO;
import com.finalproject.vo.UserAuthorityVO;
import com.finalproject.vo.UsersVO;


@Controller
@RequestMapping("/mb")
public class UsersController {
	
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	UserAuthorityBiz uabiz;
	
	@Autowired
	CarModelBiz cmbiz;

	@RequestMapping("add")
	public String add(Model m) {
		List<UserAuthorityVO> list = null;
		List<CarModelVO> cmlist = null;
		try {		
			list = uabiz.get();
			m.addAttribute("ualist", list);
			cmlist = cmbiz.get();
			m.addAttribute("cmlist", cmlist);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		m.addAttribute("center", "/mb/add");
		return "main";
	}
	
	@RequestMapping("addimpl")
	public String addimpl(Model m, UsersVO obj) {
		
		try {
			ubiz.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:select?id="+obj.getId();
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		List<UsersVO> list = null;
		try {
			list = ubiz.get();
			m.addAttribute("mlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/mb/select");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, String id) {
		UsersVO obj = null;
		List<UserAuthorityVO> list = null;
		List<CarModelVO> cmlist = null;
		try {
			obj = ubiz.get(id);
			m.addAttribute("members", obj);
			list = uabiz.get();
			m.addAttribute("ualist", list);
			cmlist = cmbiz.get();
			m.addAttribute("cmlist", cmlist);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		m.addAttribute("center","/mb/detail");
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model m, UsersVO obj) {
		
		try {
			ubiz.modify(obj);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return "redirect:detail?id="+obj.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(String id, Model m) {
		try {
			ubiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:select?id="+id;
	}
	
	
}
