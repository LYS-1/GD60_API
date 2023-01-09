package com.iu.api1.wrappers.ex1;
//960123-1907234
public class JuminCheck {
	//성별 체크 check1 주민등록번호를 받아서 남자인지 여자인지 출력
	public void check1(String s) {
		int num = Integer.parseInt(s.substring(7,8));
		int year = Integer.parseInt(s.substring(0,2));
		int day = Integer.parseInt(s.substring(4,6));
		
		switch (num) {
		case 1 :
			System.out.println("남자");
			break;
		case 2:
			System.out.println("여자");
			break;
		case 3:
			if(year>=0 && year<=23) {
				System.out.println("남자");
			}else {
				System.out.println("잘못된 번호입니다.");
			}
			break;
		case 5:
			if(year>=0 && year<=23) {
				System.out.println("여자");
			}else {
				System.out.println("잘못된 번호입니다.");
			}
			break;
		default:
			System.out.println("잘못된 번호입니다.");
			break;
		}
	}
	//check2 주민등록번호를 받아서 나이를 계산해서 출력
	//3~5 : 봄, 6~8 : 여름, 9~11 : 가을, 12~2 : 겨울 
	public void check2(String s) {
		int months = Integer.parseInt(s.substring(2,4));
		int num = Integer.parseInt(s.substring(7,8));
		int year = Integer.parseInt(s.substring(0,2));
		
		if (num == 3 || num == 5) {
			year += 2000;
		}else {
			year += 1900;
		}
		int age = 2023-year;
		System.out.println("나이: " + age);
		
		if(months>=3 && months<=5) {
			System.out.println("태어나신 계절은 봄입니다.");
		}else if(months >= 6 && months <= 8) {
			System.out.println("태어나신 계절은 여름입니다.");
		}else if(months >= 9 && months <= 11) {
			System.out.println("태어나신 계절은 가을입니다.");
		}else if(months == 12 || months <= 2) {
			System.out.println("태어나신 계절은 겨울입니다.");
		}else {
			System.out.println("잘못입력했습니다.");
		}
	}
	
}
