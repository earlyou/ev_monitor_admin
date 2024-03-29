package com.finalproject.vo;

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
public class ChgerstatusVO {

	private String chargerId;
	private String statId;
	private int chgerId;
	private int stat;
	private String method;
	private String output;
	private String statUpdDt;
	private String lastTsdt;
	private String lastTedt;
	private String nowTsdt;
	private String delYn;
	private String delDetail;
	private int chgerType;
	
	public ChgerstatusVO(String statId, int stat, String method, String output, String statUpdDt, String lastTsdt,
			String lastTedt, String nowTsdt, String delYn, String delDetail, int chgerType) {
		this.statId = statId;
		this.stat = stat;
		this.method = method;
		this.output = output;
		this.statUpdDt = statUpdDt;
		this.lastTsdt = lastTsdt;
		this.lastTedt = lastTedt;
		this.nowTsdt = nowTsdt;
		this.delYn = delYn;
		this.delDetail = delDetail;
		this.chgerType = chgerType;
	}
	
	
}
