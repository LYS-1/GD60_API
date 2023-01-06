package com.iu.api1.strings.ex3;

import java.util.Scanner;

public class WeatherController {
	//start
	private WeatherData wd = new WeatherData();
	private WeatherView wv = new WeatherView();
	private WeatherInput wi = new WeatherInput();
	Scanner sc = new Scanner(System.in);
	//1. 날씨정보 초기화
	//초기화가 완료되었습니다.
	public void reset() {	
		wd.init();
		System.out.println("초기화 완료");
	}
	//2. 전국 날씨 정보
	public void check(WeatherDTO data[]) {
		wv.viewAllWeather(data);
	}
	//3. 지역 날씨 정보 검색
	//도시정보가없습니다.
	public void search(WeatherDTO data[]) {
		WeatherDTO demo = new WeatherDTO();
		demo = wi.searchWeather(data);
		if(demo == null) {
			System.out.println("찾으시는 도시 정보가 없습니다.");
		}else {
			wv.viewOneWeather(demo);
		}
	}
	//4. 지역 날씨 추가
	//배열에 집어넣기
	public WeatherDTO[] input(WeatherDTO data[]) {
		return wi.add(data);
	}
	//5. 지역 날씨 삭제
	//배열에서 삭제
	public WeatherDTO[] deleteWeather(WeatherDTO data[]) {
		return wi.remove(data);
	}
	//6. 종료
	public boolean exitPro() {
		return false;
	}
	
	public void start() {
		boolean check = true;
		WeatherDTO data[] = wd.init();
		int num = 0;
		while(check) {
			System.out.println("행동을 선택해주세요. 1. 날씨정보 초기화 2. 전국 날씨 정보 3. 지역 날씨 정보 검색 4. 지역 날씨 정보 추가 5. 지역 날씨 삭제 6. 종료");
			num = sc.nextInt();
			switch(num) {
			case 1:
				this.reset();
				break;
			case 2:
				this.check(data);
				break;
			case 3:
				this.search(data);
				break;
			case 4:
				data = this.input(data);
				break;
			case 5:
				data = this.deleteWeather(data);
				break;
			case 6:
				check = exitPro();
				break;
			default:
				System.out.println("다시 선택해주세요");
				continue;
			}
			System.out.println();
		}
	}
	
}
