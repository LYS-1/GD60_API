package com.iu.api2.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> numArr = new ArrayList<>();
		//1000원 로또구매 1-45 번호 6개를 랜덤하게 추출
		boolean check = true;
		
		int count = 0;
		
		while(check) {
			int num = r.nextInt(45) + 1;
			boolean same = false;
			if(numArr.size() > 1) {
				for(int i = 0 ; i < numArr.size(); i ++) {
					if(numArr.get(i) == num) {
						same = true;
						break;
					}else {
						continue;
					}
				}
			}
			if(same == false) {
				numArr.add(num);
			}
			if(numArr.size() == 6) {
				check = false;
			}
		}
		
		System.out.println("길이 : " + numArr.size());
		
		for(int i = 0; i < numArr.size(); i ++) {
			System.out.println(numArr.get(i));
		}
		
//		HashSet<Integer> hs = new HashSet<>();
//		while(hs.size() < 6) {
//			hs.add(r.nextInt(45)+1);
//		}
	}
}	
