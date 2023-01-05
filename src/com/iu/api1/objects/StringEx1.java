package com.iu.api1.objects;

public class StringEx1 {
	public static void main(String[] args) {
		String phone = "010-1234-5678";
		boolean check = true;
		int idx = 0;
		while(check) {
			idx = phone.indexOf('-', idx);
			if(idx != -1) {
				System.out.println("IDX : " + idx);
				idx++;
			}else {
				check = false;
				break;
			}
		}
		
//		String demo= "";
//		char[] number = phone.toCharArray();
//		for(int i = 0 ; i < number.length; i ++) {
//			if(number[i] == '-') {
//				continue;
//			}
//			demo = demo + number[i];
//		}
//		System.out.println(demo);
	}
}
