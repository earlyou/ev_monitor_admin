package com.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.frame.Util;
import com.finalproject.vo.CarModelVO;


@Controller
@RequestMapping("/vm")
public class CarModelController {
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	CarModelBiz cmbiz;
	
	@RequestMapping("add")
	public String add(Model m) {
		m.addAttribute("center", "/vm/add");
		return "main";
	}
	
	@RequestMapping("/addimpl")
	public String registerimpl(Model m, CarModelVO ev) {
		
		String carimg = ev.getMf().getOriginalFilename();
		ev.setCarimg(carimg);
		try {
			cmbiz.register(ev);
			Util.saveFile(ev.getMf(),admindir,userdir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/vm/detail");
		return "redirect:select";
	}
	
	@RequestMapping("select")
	public String select(Model m) {
		List<CarModelVO> list = null;
		try {
			list = cmbiz.get();
			m.addAttribute("evlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "/vm/select");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, int carmodelid) {
		CarModelVO obj = null;
		try {
			obj = cmbiz.get(carmodelid);
			m.addAttribute("cmv", obj);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		m.addAttribute("center","/vm/detail");
		return "main";
	}
	
	@RequestMapping("/updateimpl")
	public String update(Model m, CarModelVO ev) {
		
		String carname = ev.getMf().getOriginalFilename();
		if(!(carname.equals(""))){
			ev.setCarimg(carname);
			Util.saveFile(ev.getMf(),admindir,userdir);
		}	
		
		try {
			cmbiz.modify(ev);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return "redirect:detail?carmodelid="+ev.getCarmodelid();
	}
	
	@RequestMapping("/delete")
	public String delete(int carmodelid, Model m) {
		try {
			cmbiz.remove(carmodelid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:select?carmodelid="+carmodelid;
	}
}
