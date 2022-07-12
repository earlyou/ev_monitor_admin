package com.finalproject.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarModelVO {
	private int carmodelid;
	private String mname;
	private String mbrand;
	private String carimg;
	private double crange;
	private double batterysize;
	private int fptid;
	private int sptid;
	
}
