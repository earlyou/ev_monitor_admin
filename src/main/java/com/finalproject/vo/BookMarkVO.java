package com.finalproject.vo;

public class BookMarkVO {
	
	private int bsid;
	private int statid;
	private String uid;
	private int zcode;
	private String statnm;
	
	
	public BookMarkVO(int statid, String uid, int zcode, String statnm) {
		this.statid = statid;
		this.uid = uid;
		this.zcode = zcode;
		this.statnm = statnm;
	}
	
	

}
