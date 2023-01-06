package com.iu.api1.strings.ex3;

public class WeatherView {
	//2개의 메서드 1. 모든 날씨의 정보 출력 2. DTO하나의 정보를 출력
	public void viewAllWeather(WeatherDTO data[]) {
		for ( int i = 0;  i < data.length; i ++) {
			System.out.println("---------------");
			System.out.println((i+1) + "번째 도시 이름 : " + data[i].getCity());
			System.out.println((i+1) + "번째 도시 기온 : " + data[i].getGion());
			System.out.println((i+1) + "번째 도시 날씨 : " + data[i].getStatus());
			System.out.println((i+1) + "번째 도시 미세먼지 농도 : " + data[i].getMise() + "%");
			
			
		}		
	}
	
	public void viewOneWeather(WeatherDTO data) {
		System.out.println("도시 이름: " + data.getCity());
		System.out.println("기온 : " + data.getGion());
		System.out.println("날씨 : " + data.getStatus());
		System.out.println("미세먼지 농도 : " + data.getMise() + "%");
	}
	
}
