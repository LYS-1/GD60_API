package com.iu.api2.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMain4 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//2023년 1월 11일 -> format
		SimpleDateFormat sd = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		System.out.println(sd.format(c.getTime()));
	}
}
