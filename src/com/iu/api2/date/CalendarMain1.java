package com.iu.api2.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarMain1 {
	public static void main(String[] args) {
		//gregoriancalendar
		Calendar c = new GregorianCalendar();
		c = Calendar.getInstance();
		System.out.println(c);
		c.set(Calendar.YEAR, 2032);
		c.set(Calendar.MONTH, 11);
		
		//year
		int year = c.get(Calendar.YEAR);
		System.out.println("year : " + year );
		//month
		int month = c.get(Calendar.MONTH);
		//date
		int date = c.get(Calendar.DATE);
		//day
		int day = c.get(Calendar.DAY_OF_WEEK);
		//일~토 - 1~8
		//시 분 초
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		System.out.println("month : " + (month+1));
		System.out.println("date : " + date);
		System.out.println("day : " + day);
		System.out.println("hour : " + hour);
		System.out.println("min : " + min);
		System.out.println("sec : " +sec);
	}
}
