package com.iu.api3.exception;

import java.util.Random;

public class ExceptionSample1 {
	
	public void ex1() throws ArithmeticException, NullPointerException, Exception{
		Random ran = new Random();
		int num = ran.nextInt(2);
		
		num = 10/num;
		
		System.out.println(num);

	}
	
	public void ex2() throws CustomException {
		int num1 = 65;
		int num2 = 48;
		//int sum = num1 + num2;
		
		int sum = num2 - num1;
		if(sum < 0) {
			throw new CustomException("음수는 몬읽어요");
		}
		if(sum > 99) {
			throw new CustomException("dont know");
		} 
	}
}
