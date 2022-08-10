package com.finalproject.vo;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

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
	
	private MultipartFile mf;
	
	public CommunityVO(int pid, String uid, String statid, String location, String title, String tf, String cimgname,
			Date regdate) {
		this.pid = pid;
		this.uid = uid;
		this.statid = statid;
		this.location = location;
		this.title = title;
		this.tf = tf;
		this.cimgname = cimgname;
		this.regdate = regdate;
	}
	


	
}
