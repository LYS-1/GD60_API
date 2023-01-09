package com.iu.api1.wrappers;

public class Wrapper2 {
	public static void main(String[] args) {
		int num = 10;
		
		//Integer num2 = new Integer(num);
		//Auto-Boxing : primitive -> reference
		Integer num2 = num;
		//Auto=UnBoxing : reference -> primitive
		//num = num2.intValue();
		num = num2;
	}
}
