package com.iu.api1.wrappers.ex1;

public class JuminCheck2 {
	//check 주민등록번호 매개변수
	//980724-1234567
	//맨끝자리는 체크용 번호로 뺌
	// 9 8 0 7 2 4 - 1 2 3 4 5 6
	// 2 3 4 5 6 7   8 9 2 3 4 5
	// 18 24 0 35 12 28 8 18 6 12 20 30 다 더함 -> 대략 122
	//합을 11로 나누어서 나머지를 구한다 : 몫 11 나머지 1
	//나머지 값을 11로 뺀 결과 값하고 체크용 번호가 같은지 확인
	//11 - 1 = 10
	//만약에 결과값이 두자리면 다시 10으로 나눈 나머지를 체크용 번호랑 같은지 확인
	//10/10 몫:1, 나머지:0 0==7?
	
	public void check(String s) {
		String num = s.replace("-", "");
		int sum = 0;
		int count = 2;
		for(int i = 0 ; i < num.length()-1; i ++) {
			if( count == 10 ) {
				count = 2;
			}
			//String.valueOf(num.charAt(i)): char -> string
			sum += Integer.parseInt(num.substring(i,i+1)) * count;
			count ++;
		}
		int check = 11 - sum % 11;
		if(check >= 10) {
			check = check % 10;
		}
		if(check == Integer.parseInt(s.substring(13,14))) {
			System.out.println("정상 번호입니다.");
		}else {
			System.out.println("잘못된 번호.");
		}
	}
}
