package com.finalproject.vo;

import java.util.Date;

public class UsersVO {

	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String phonenum;
	private String email;
	private String clp;
	private int usertypeid;
	private Date regdate;
	private int carmodelid;
	
	private String uauserstypename;

	public UsersVO(String id, String pwd, String name, String nickname, String phonenum, String email, String clp,
			int usertypeid, Date regdate, int carmodelid, String uauserstypename) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.phonenum = phonenum;
		this.email = email;
		this.clp = clp;
		this.usertypeid = usertypeid;
		this.regdate = regdate;
		this.carmodelid = carmodelid;
		this.uauserstypename = uauserstypename;
	}

	public UsersVO(String pwd, String name, String nickname, String phonenum, String email, String clp, int usertypeid,
			Date regdate, int carmodelid, String uauserstypename) {
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.phonenum = phonenum;
		this.email = email;
		this.clp = clp;
		this.usertypeid = usertypeid;
		this.regdate = regdate;
		this.carmodelid = carmodelid;
		this.uauserstypename = uauserstypename;
	}
	
	
	
	
}
