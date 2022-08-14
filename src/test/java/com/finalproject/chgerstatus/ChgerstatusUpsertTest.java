package com.finalproject.chgerstatus;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.biz.ChgerstatusBiz;
import com.finalproject.restapi.UpsertAPI;
import com.finalproject.vo.ChgerstatusVO;

@SpringBootTest
class ChgerstatusUpsertTest {
	
	@Autowired
	ChgerstatusBiz chgerstatusbiz;
	
	@Autowired
	UpsertAPI upsertapi;
	
	@Test
	void contextLoads() {
		JSONObject data = null;
		String region = "11";
		String numOfRows = "10";
		double start = System.currentTimeMillis();
		try {
			data = upsertapi.data(2,numOfRows,region);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		double end = System.currentTimeMillis();
		System.out.println("데이터 개요 불러오기: " + (double) ((end - start)/1000) + " s");
		
		numOfRows = "9999";
		int numofrows = Integer.parseInt(numOfRows); 
		JSONObject header = data.getJSONObject("response").getJSONObject("header");
		int totalCount = header.getInt("totalCount");
		int totalpage = (totalCount/numofrows)+2;
		System.out.println("불러 올 데이터 수: "+totalCount+" 개");
		
		String chargerId = "";
		String statId = "";
		int chgerId = 0;
		int stat = 0;
		String method = "";
		String output = "";
		String statUpdDt = "";
		String lastTsdt = "";
		String lastTedt = "";
		String nowTsdt = "";
		String delYn = "";
		String delDetail = "";
		int chgerType = 0;
		
		JSONObject json = null;
		int cnt = 0;
		int newdata = 0;
		List<ChgerstatusVO> modilist = new ArrayList<ChgerstatusVO>();
		
		try {
			start = System.currentTimeMillis();
			json = upsertapi.data(totalpage,numOfRows,region);
			end = System.currentTimeMillis();
			System.out.println("데이터 불러오기 완료: " + (double) ((end - start)/1000) + " s");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		start = System.currentTimeMillis();
		if (totalCount <= numofrows) {	// JSON이 1개일 때(데이터가 적은 수도권 이외 지역)
			for (int i = 0; i < numofrows; i++) {
				++cnt;
				if (cnt > totalCount) {
					break;
				}
				JSONArray item = json.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
				statId = item.getJSONObject(i).get("statId").toString();
				chgerId = Integer.parseInt(item.getJSONObject(i).get("chgerId").toString());
				chargerId = statId+chgerId;
				stat = Integer.parseInt(item.getJSONObject(i).get("stat").toString());
				method = item.getJSONObject(i).get("method").toString();
				output = item.getJSONObject(i).get("output").toString();
				if (output == "") {
					output = null;
				}
				statUpdDt = item.getJSONObject(i).get("statUpdDt").toString();
				lastTsdt = item.getJSONObject(i).get("lastTsdt").toString();
				lastTedt = item.getJSONObject(i).get("lastTedt").toString();
				nowTsdt = item.getJSONObject(i).get("nowTsdt").toString();
				delYn = item.getJSONObject(i).get("delYn").toString();
				delDetail = item.getJSONObject(i).get("delDetail").toString();
				chgerType = Integer.parseInt(item.getJSONObject(i).get("chgerType").toString());
				ChgerstatusVO chger = new ChgerstatusVO(chargerId, statId, chgerId, stat, method, output, statUpdDt, lastTsdt, lastTedt, nowTsdt, delYn, delDetail, chgerType);

				modilist.add(chger);
				++newdata;
			}
		}else {	// JSON이 2개 이상일 때(데이터가 많은 수도권)
			JSONArray response = json.getJSONArray("response");
			for (int i = 0; i < totalpage-1; i++) {
				for (int j = 0; j < numofrows; j++) {
					++cnt;
					if (cnt > totalCount) {
						break;
					}
					JSONArray item = response.getJSONObject(i).getJSONObject("body").getJSONObject("items").getJSONArray("item");
					statId = item.getJSONObject(j).get("statId").toString();
					chgerId = Integer.parseInt(item.getJSONObject(j).get("chgerId").toString());
					chargerId = statId+chgerId;
					stat = Integer.parseInt(item.getJSONObject(j).get("stat").toString());
					method = item.getJSONObject(j).get("method").toString();
					output = item.getJSONObject(j).get("output").toString();
					if (output == "") {
						output = null;
					}
					statUpdDt = item.getJSONObject(j).get("statUpdDt").toString();
					lastTsdt = item.getJSONObject(j).get("lastTsdt").toString();
					lastTedt = item.getJSONObject(j).get("lastTedt").toString();
					nowTsdt = item.getJSONObject(j).get("nowTsdt").toString();
					delYn = item.getJSONObject(j).get("delYn").toString();
					delDetail = item.getJSONObject(j).get("delDetail").toString();
					chgerType = Integer.parseInt(item.getJSONObject(j).get("chgerType").toString());
					ChgerstatusVO chger = new ChgerstatusVO(chargerId, statId, chgerId, stat, method, output, statUpdDt, lastTsdt, lastTedt, nowTsdt, delYn, delDetail, chgerType);

					modilist.add(chger);
					++newdata;
				}
			}
		}
		try {
			chgerstatusbiz.upsert(modilist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========================Fin.=========================");
		end = System.currentTimeMillis();
		System.out.println("데이터 업데이트하기: " + (double) ((end - start)/1000) + " s");
		System.out.println("업데이트 된 데이터 수: "+newdata+" 개");
	}

}
