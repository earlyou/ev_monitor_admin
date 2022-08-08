package com.finalproject.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
public class CommunityVO  {
	private int pid;
	private String uid;
	private String location;
	private String title;
	private String statid;
	private String tf;
	private String cimgname;
	private Date regdate;	
	private MultipartFile mf;
	
	public CommunityVO() {
	}

	public CommunityVO(int pid, String uid, String location, String title, String statid, String tf, String cimgname,
			Date regdate) {
		this.pid = pid;
		this.uid = uid;
		this.location = location;
		this.title = title;
		this.statid = statid;
		this.tf = tf;
		this.cimgname = cimgname;
		this.regdate = regdate;
	}

	// insert

	public CommunityVO(String uid, String location, String title, String tf, String cimgname) {
		this.uid = uid;
		this.location = location;
		this.title = title;
		this.tf = tf;
		this.cimgname = cimgname;
	}
	// update

	public CommunityVO(int pid, String uid, String location, String title, String tf, String cimgname) {
		this.pid = pid;
		this.uid = uid;
		this.location = location;
		this.title = title;
		this.tf = tf;
		this.cimgname = cimgname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStatid() {
		return statid;
	}

	public void setStatid(String statid) {
		this.statid = statid;
	}

	public String getCimgname() {
		return cimgname;
	}

	public void setCimgname(String cimgname) {
		this.cimgname = cimgname;
	}

	public MultipartFile getMf() {
		return mf;
	}

	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}
	
}

