package com.iu.api1.wrappers.ex1;

import java.util.Scanner;

public class Ex1Main {
	public static void main(String[] args) {
//		String number = "980724-1234567";
		JuminCheck c = new JuminCheck();
		JuminCheck2 c2 = new JuminCheck2();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민등록번호 입력");
		String number = sc.next();
		
		c.check1(number);
		c.check2(number);
		c2.check(number);
	}
}
