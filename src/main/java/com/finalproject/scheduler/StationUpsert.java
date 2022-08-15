package com.finalproject.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finalproject.biz.StationBiz;
import com.finalproject.restapi.UpsertAPI;
import com.finalproject.vo.StationVO;

@Component
public class StationUpsert {

	@Autowired
	StationBiz stationbiz;
	
	@Autowired
	UpsertAPI upsertapi;
	
	@Scheduled(cron = "0 0 */2 * * *") // everyday at 2AM
	public void upsertstation() {
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
		
		
		String statId = "";
		String statNm = "";
		String addr = "";
		String location = "";
		String zcode = "";
		String lat = "";
		String lng = "";
		String useTime = "";
		String parkingFree = "";
		String note = "";
		String limitYn = "";
		String limitDetail = "";
		String busiId = "";
		String bnm = "";
		String busiNm = "";
		String busiCall = "";
		
		JSONObject json = null;
		int cnt = 0;
		int newdata = 0;
		List<StationVO> uplist = new ArrayList<StationVO>();
		
		try {
			start = System.currentTimeMillis();
			json = upsertapi.data(totalpage,numOfRows,region);
			end = System.currentTimeMillis();
			System.out.println("데이터 불러오기: " + (double) ((end - start)/1000) + " s");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		start = System.currentTimeMillis();
		
		System.out.println("==================================================Start Inserting Station Information==================================================");
			if (totalCount <= numofrows) {	// JSON이 1개일 때(데이터가 적은 수도권 이외 지역)
				for (int i = 0; i < numofrows; i++) {
					++cnt;
					if (cnt > totalCount) {
						break;
					}
					JSONArray item = json.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
					if (item.getJSONObject(i).get("chgerId").toString().equals("01")) {
						statId = item.getJSONObject(i).get("statId").toString();
						statNm = item.getJSONObject(i).get("statNm").toString();
						addr = item.getJSONObject(i).get("addr").toString();
						location = item.getJSONObject(i).get("location").toString();
						zcode = item.getJSONObject(i).get("zcode").toString();
						lat = item.getJSONObject(i).get("lat").toString();
						lng = item.getJSONObject(i).get("lng").toString();
						useTime = item.getJSONObject(i).get("useTime").toString();
						parkingFree = item.getJSONObject(i).get("parkingFree").toString();
						note = item.getJSONObject(i).get("note").toString();
						limitYn = item.getJSONObject(i).get("limitYn").toString();
						limitDetail = item.getJSONObject(i).get("limitDetail").toString();
						busiId = item.getJSONObject(i).get("busiId").toString();
						bnm = item.getJSONObject(i).get("bnm").toString();
						busiNm = item.getJSONObject(i).get("busiNm").toString();
						busiCall = item.getJSONObject(i).get("busiCall").toString();
						StationVO station = new StationVO(statId, statNm, addr, location, zcode, lat, lng, useTime, parkingFree, note, limitYn, limitDetail, busiId, bnm, busiNm, busiCall);
						
						uplist.add(station);
						++newdata;
					}
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
						if (item.getJSONObject(j).get("chgerId").toString().equals("01")) {
							statId = item.getJSONObject(j).get("statId").toString();
							statNm = item.getJSONObject(j).get("statNm").toString();
							addr = item.getJSONObject(j).get("addr").toString();
							location = item.getJSONObject(j).get("location").toString();
							zcode = item.getJSONObject(j).get("zcode").toString();
							lat = item.getJSONObject(j).get("lat").toString();
							lng = item.getJSONObject(j).get("lng").toString();
							useTime = item.getJSONObject(j).get("useTime").toString();
							parkingFree = item.getJSONObject(j).get("parkingFree").toString();
							note = item.getJSONObject(j).get("note").toString();
							limitYn = item.getJSONObject(j).get("limitYn").toString();
							limitDetail = item.getJSONObject(j).get("limitDetail").toString();
							busiId = item.getJSONObject(j).get("busiId").toString();
							bnm = item.getJSONObject(j).get("bnm").toString();
							busiNm = item.getJSONObject(j).get("busiNm").toString();
							busiCall = item.getJSONObject(j).get("busiCall").toString();
							StationVO station = new StationVO(statId, statNm, addr, location, zcode, lat, lng, useTime, parkingFree, note, limitYn, limitDetail, busiId, bnm, busiNm, busiCall);

							uplist.add(station);
							++newdata;
						}
					}
				}
			}
			try {
				stationbiz.upsert(uplist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("===========================================================================Fin.===========================================================================");
		end = System.currentTimeMillis();
		System.out.println("데이터 입력하기: " + (double) ((end - start)/1000) + " s");
		System.out.println("새로 입력된 데이터 수: "+newdata+" 개");
	}
}
