package com.iu.api1.strings.ex3;

import java.util.Scanner;

public class WeatherInput {
	WeatherView wv = new WeatherView();
	//search
	//배열을 받고 키보드로부터 검색할 도시명을 입력받기.
	//찾은 DTO리턴 , 없으면 null.
	public WeatherDTO searchWeather(WeatherDTO data[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("도시 이름을 입력하세요");
		String city = sc.next().toUpperCase();
		WeatherDTO returnData = null;
		for(int i = 0; i < data.length; i ++) {
			if(data[i].getCity().equals(city)) {
				System.out.println("검색됨");
				returnData = data[i];
			}
		}
		return returnData;
	}
	//add
	//배열을 받고 키보드로부터 정보를 입력받기.
	//배열을 리턴
	public WeatherDTO[] add(WeatherDTO data[]) {
		WeatherDTO newData[] = new WeatherDTO[(data.length+1)];
		for(int i = 0; i < data.length; i ++) {
			newData[i] = data[i];
		}
		WeatherDTO input = new WeatherDTO();
		Scanner sc = new Scanner(System.in);
		System.out.println("도시 이름을 입력하세요");
		String city = sc.next();
		input.setCity(city.toUpperCase());
		System.out.println("온도를 입력하세요");
		String gion = sc.next();
		input.setGion(gion);
		System.out.println("날씨 상태를 입력하세요");
		String status = sc.next();
		input.setStatus(status);
		System.out.println("미세먼지 농도를 입력하세요");
		String mise = sc.next();
		input.setMise(mise);
		newData[newData.length-1] = input;
		return newData;
	}
	//remove
	//배열을 받고 키보드로부터 삭제할 도시명을 입력받음.
	//배열에서 삭제하고 배열을 리턴.
	public WeatherDTO[] remove(WeatherDTO data[]) {
		WeatherDTO data1[] = data;
		System.out.println(data1.length);
		WeatherDTO newData[] = new WeatherDTO[data1.length-1];
		Scanner sc = new Scanner(System.in);
		System.out.println("도시 이름을 입력하세요");
		String city = sc.next().toUpperCase();
		
		int count = 0;
		boolean check = false;
		for(int i = 0; i < data.length; i ++) {
			if(data[i].getCity().equals(city) == true) {
				check = true;
			}else {
				newData[count] = data[i];
				count ++;
				if(count == data.length && check == false) {
					System.out.println("없는 도시입니다.");
					return data1;
				}
			}
		}
		System.out.println(city + "도시 삭제");
		return newData;
	}
}
