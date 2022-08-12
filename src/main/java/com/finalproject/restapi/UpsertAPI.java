package com.finalproject.restapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class UpsertAPI{
	public JSONObject data(int page, String nor, String region) throws Exception{
		StringBuilder sb = null;
		JSONObject json = null;
		String data = "";
		for (int i = 1; i < page; i++) {
			String a = String.valueOf(i);
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/EvCharger/getChargerInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=DqRhUJBDHRjv%2FkZxGopglI43TRljwKU5U9f5lYDbUmuljrmIvyl2g8kfjgV6pLYsYPX8u8Eviwq311c%2FOnt8%2Bg%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(a, "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(nor, "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
	        urlBuilder.append("&" + URLEncoder.encode("zcode","UTF-8") + "=" + URLEncoder.encode(region, "UTF-8")); /*시도 코드 (행정구역코드 앞 2자리)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        data += sb.toString();
	        rd.close();
	        conn.disconnect();
		}
		json = XML.toJSONObject(data);
		return json;
	}
}