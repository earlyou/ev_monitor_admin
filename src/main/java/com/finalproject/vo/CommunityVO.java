package com.finalproject.vo;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityVO  {
	private int pid;
	private String uid;
	private String statid;
	private String location;
	private String title;
	private String tf;
	private String cimgname;
	private Date regdate;
	

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
	
}
