package com.iu.api1.strings.ex3;

import java.util.StringTokenizer;

public class WeatherData {
	
	private String data;
	
	public WeatherData() {
		this.data = "SEOUL, 12, 맑음, 60, DAEGU, 68, 비, 10,"
				+ "JEJU, -56, 눈, 12, JUNJU, 32, 흐림, 5";
		
	}
	public WeatherDTO[] init() {
		StringTokenizer st = new StringTokenizer(this.data, ", ");
		WeatherDTO DTO[] = new WeatherDTO[st.countTokens()/4];
		int count = 0;
		while(st.hasMoreTokens()) {
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setCity(st.nextToken());
			weatherDTO.setGion(Integer.parseInt(st.nextToken()));
			weatherDTO.setStatus(st.nextToken());
			weatherDTO.setMise(Integer.parseInt(st.nextToken()));
			DTO[count] = weatherDTO;
			count ++;
		}
		
		return DTO;
	}
	//init : dat를 파싱해서 각 data를 DTO에 대입하고 DTO들을 리턴
//	public WeatherDTO[] init() {		
//		String result[] = data.split(",");
//		WeatherDTO DTO[] = new WeatherDTO[result.length/4];
//		int count = 0;
//
//		for(int i = 0; i < result.length; i = i+4) {
//			result[i] = result[i].trim();
//			result[i+1] = result[i+1].trim();
//			result[i+2] = result[i+2].trim();
//			result[i+3] = result[i+3].trim();
//			WeatherDTO weatherDTO = new WeatherDTO();
//			weatherDTO.setCity(result[i]);
//			weatherDTO.setGion(Integer.parseInt(result[i+1]));
//			weatherDTO.setStatus(result[i+2]);
//			weatherDTO.setMise(Integer.parseInt(result[i+3]));
//			
//			DTO[count] = weatherDTO;
//			count ++;
//		}		
//		return DTO;
//	}
	
	
	
	
}
