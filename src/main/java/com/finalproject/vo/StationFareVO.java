package com.finalproject.vo;

public class StationFareVO {
	private int cid;
	private String busiId;
	private String bnm;
	private String cs;
	private String memYN;
	private String apartYN;
	private String time;
	private String seasons;
	private String cf;
	
	public StationFareVO() {
	}

	public StationFareVO(int cid, String busiId, String bnm, String cs, String memYN, String apartYN, String time,
			String seasons, String cf) {
		this.cid = cid;
		this.busiId = busiId;
		this.bnm = bnm;
		this.cs = cs;
		this.memYN = memYN;
		this.apartYN = apartYN;
		this.time = time;
		this.seasons = seasons;
		this.cf = cf;
	}
// 업데이트(수정) 생성자
//	cid = # {cid}, busiId=#{busiId}, bnm=#{bnm},cs=#{cs}, #{time},#{seasons},#{cf} WHERE cid=#{cid}
	public StationFareVO(int cid, String busiId, String bnm, String cs, String time, String seasons, String cf) {
		this.cid = cid;
		this.busiId = busiId;
		this.bnm = bnm;
		this.cs = cs;
		this.time = time;
		this.seasons = seasons;
		this.cf = cf;
	}

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBnm() {
		return bnm;
	}

	public void setBnm(String bnm) {
		this.bnm = bnm;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getMemYN() {
		return memYN;
	}

	public void setMemYN(String memYN) {
		this.memYN = memYN;
	}

	public String getApartYN() {
		return apartYN;
	}

	public void setApartYN(String apartYN) {
		this.apartYN = apartYN;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSeasons() {
		return seasons;
	}

	public void setSeasons(String seasons) {
		this.seasons = seasons;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "StationFareVO [cid=" + cid + ", busiId=" + busiId + ", bnm=" + bnm + ", cs=" + cs + ", memYN=" + memYN
				+ ", apartYN=" + apartYN + ", time=" + time + ", seasons=" + seasons + ", cf=" + cf + "]";
	}
	
}
	