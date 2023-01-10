package com.iu.api2.collections.ex1;

import java.util.ArrayList;

public class StudentView {
	public void view(ArrayList<StudentDTO> ar) {
		for(StudentDTO a :ar) {
			System.out.println("이름 : " + a.getName());
			System.out.println("이름 : " + a.getNumber());
			System.out.println("이름 : " + a.getKor());
			System.out.println("이름 : " + a.getEng());
			System.out.println("이름 : " + a.getMath());
			System.out.println("이름 : " + a.getSum());
			System.out.println("이름 : " + a.getAvg());
			System.out.println("=============================");
		}
	}
	public void view(StudentDTO sDTO) {
		System.out.println("이름 : " + sDTO.getName());
		System.out.println("이름 : " + sDTO.getNumber());
		System.out.println("이름 : " + sDTO.getKor());
		System.out.println("이름 : " + sDTO.getEng());
		System.out.println("이름 : " + sDTO.getMath());
		System.out.println("이름 : " + sDTO.getSum());
		System.out.println("이름 : " + sDTO.getAvg());
	}
	public void view(String s) {
		System.out.println(s);
	}
}
