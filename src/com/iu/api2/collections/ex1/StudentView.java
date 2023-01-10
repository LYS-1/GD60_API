package com.iu.api2.collections.ex1;

import java.util.ArrayList;

public class StudentView {
	
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<Integer> number = new ArrayList<Integer>();
	ArrayList<Integer> kor = new ArrayList<Integer>();
	ArrayList<Integer> eng = new ArrayList<Integer>();
	ArrayList<Integer> math = new ArrayList<Integer>();
	ArrayList<Integer> sum = new ArrayList<Integer>();
	ArrayList<Double> avg = new ArrayList<Double>();
	
	public void view(StudentDAO std, String s) {
		name = std.getName();
		number = std.getNumber();
		kor = std.getKor();
		eng = std.getEng();
		math = std.getMath();
		sum = std.getSum();
		avg = std.getAvg();
		int id = 0;
		for( int i = 0; i < name.size(); i ++) {
			if(name.get(i).equals(s)) {
				id = i;
				break;
			}
		}
		System.out.println("학생의 이름 " + name.get(id));
		System.out.println("학생의 번호 " + number.get(id));
		System.out.println("학생의 국어 성적 " + kor.get(id));
		System.out.println("학생의 영어 성적 " + eng.get(id));
		System.out.println("학생의 수학 성적 " + math.get(id));
		System.out.println("학생의 총성적 " + sum.get(id));
		System.out.println("학생의 평균 성적 " + avg.get(id));
	}
	public void viewAll(StudentDAO std) {
		name = std.getName();
		number = std.getNumber();
		kor = std.getKor();
		eng = std.getEng();
		math = std.getMath();
		sum = std.getSum();
		avg = std.getAvg();
		for( int i = 0 ; i < name.size(); i ++) {
			System.out.println("학생의 이름 " + name.get(i));
			System.out.println("학생의 번호 " + number.get(i));
			System.out.println("학생의 국어 성적 " + kor.get(i));
			System.out.println("학생의 영어 성적 " + eng.get(i));
			System.out.println("학생의 수학 성적 " + math.get(i));
			System.out.println("학생의 총성적 " + sum.get(i));
			System.out.println("학생의 평균 성적 " + avg.get(i));
			System.out.println("========================================");
		}
	}
}
