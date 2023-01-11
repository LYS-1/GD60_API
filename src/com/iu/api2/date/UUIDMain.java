package com.iu.api2.date;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class UUIDMain {
	public static void main(String[] args) {
		String str = UUID.randomUUID().toString();
		System.out.println(str);
		
		Calendar c = Calendar.getInstance();
		str = c.getTimeInMillis() + "abc";
		
		Random random = new Random(c.getTimeInMillis());
		
	}
}
