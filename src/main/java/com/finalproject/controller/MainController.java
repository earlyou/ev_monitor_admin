package com.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.biz.CarModelBiz;
import com.finalproject.biz.MainBiz;
import com.finalproject.biz.UsersBiz;
import com.finalproject.vo.CarModelVO;
import com.finalproject.vo.ChargerVO;
import com.finalproject.vo.CommunityVO;
import com.finalproject.vo.StationFareVO;
import com.finalproject.vo.UsersVO;

@Controller
public class MainController {
		
	@Autowired
	MainBiz biz;
	
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	CarModelBiz cmbiz;
	
	@RequestMapping("/")
	public String main(Model m, String id) {
		
		m.addAttribute("login","login");
		
		UsersVO obj = null;
		List<CarModelVO> cmlist = null;
		int custcnt = 0;
		int admincnt = 0;
		int carmodelcnt = 0;
		int chargercnt = 0;
		int communitycnt = 0;
		int stationcnt = 0;
		
		m.addAttribute("center","center");
		
		try {
			custcnt = biz.getCustomerCnt();
			admincnt = biz.getAdminCnt();
			carmodelcnt = biz.getCarModelCnt();
			chargercnt = biz.getChargerCnt();
			communitycnt = biz.getCommunityCnt();
			stationcnt = biz.getStationCnt();
			m.addAttribute("custcnt", custcnt);
			m.addAttribute("admincnt", admincnt);
			m.addAttribute("carmodelcnt", carmodelcnt);
			m.addAttribute("chargercnt", chargercnt);
			m.addAttribute("communitycnt", communitycnt);
			m.addAttribute("stationcnt",stationcnt);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(Model m, HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
		
		UsersVO admin = null;
		try {
			admin = ubiz.get(id);
			if(admin == null) {
				throw new Exception();
			}			
			if(admin.getPwd().equals(pwd) && admin.getUsertypeid()==200) {
				session.setAttribute("loginadmin", admin);
				m.addAttribute("center","center");	
				return "main";
			}else if(admin.getPwd().equals(pwd) && admin.getUsertypeid()!=200){	
				m.addAttribute("loginfail","관리자 계정이 아닙니다.");
				m.addAttribute("login","login");		
				return "main";	
			}else{
				m.addAttribute("loginfail"," 아이디 또는 비밀번호를 잘못 입력했습니다. ");
				m.addAttribute("login","login");		
				return "main";							
			}		
		} catch (Exception e) {
		
			m.addAttribute("loginfail"," 아이디 또는 비밀번호를 잘못 입력했습니다. ");
			m.addAttribute("login","login");		
			return "main";
		}
	}
	
	@RequestMapping("search")
	public String search(Model m, String srchtext, String srchselect) {
		
	List<UsersVO> mlist = null;
	List<CarModelVO> evlist = null;
	List<StationFareVO> sflist = null;
	List<ChargerVO> ctlist = null;
	List<CommunityVO> cmlist = null;
	
	switch(srchselect){
	case "stationfare" :	
		try {
			sflist = biz.searchfare(srchtext);
			m.addAttribute("sflist", sflist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
		
	case "chargingtype" :	
		try {
			ctlist = biz.searchcharger(srchtext);
			m.addAttribute("ctlist", ctlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
	
	case "electricvehicle" :	
		try {
			evlist = biz.searchev(srchtext);
			m.addAttribute("evlist", evlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;

	case "communityuid" :	
		try {
			cmlist = biz.searchcommunityuid(srchtext);
			m.addAttribute("cmlist", cmlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;		
		
	case "customer" :
		try {
			mlist = biz.searchcustomer(srchtext);
			m.addAttribute("mlist", mlist);
			m.addAttribute("usertypeid", 100);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		break;
						
	case "admin" :
		try {
			mlist = biz.searchadmin(srchtext);
			m.addAttribute("mlist", mlist);
			m.addAttribute("usertypeid", 200);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		break;	
		}					
		m.addAttribute("center", "search");
		return "main";
	}
	
	

}
