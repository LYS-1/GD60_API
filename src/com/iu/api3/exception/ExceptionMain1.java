package com.iu.api3.exception;

import java.util.Random;

public class ExceptionMain1 {
	public static void main(String[] args) {
		String num = null;
		Random r = new Random();
		int n = r.nextInt(2);
		
		if(n==0) {
			num = "test";
		}
		
		try {
			int a = 10;
			System.out.println(num.charAt(0));
			System.out.println(3/n);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("예외 발생");
			int a = 100;
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("null값");
		} catch (Exception e) {
			
		} catch (Throwable e) {
			
		}
		
//		System.out.println(a);
		
		
		
		System.out.println("종료합니다.");
		
	}
}
