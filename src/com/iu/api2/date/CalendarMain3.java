package com.iu.api2.date;

import java.util.Calendar;

public class CalendarMain3 {
	public static void main(String[] args) {
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.DATE, 30);
		Calendar c2 = Calendar.getInstance();
		
//		c2.set(Calendar.DATE, c1.get(Calendar.DATE) + 3);
		c2.set(Calendar.DATE, c1.get(Calendar.DATE));
		long d = 1000*60*60*24*3;
		c2.setTimeInMillis(c2.getTimeInMillis() + d);
		c2.add(Calendar.DATE, 3);
//		c2.roll(Calendar.DATE, 3);
		System.out.println(c1.getTime());
		System.out.println(c2.getTime());
	}
}
