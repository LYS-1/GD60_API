package com.iu.api2.collections.ex1;

import java.util.ArrayList;

public class Ex1Main {
	public static void main(String[] args) {
		//학생 이름 번호 국어 영어 수학 총점 평균
		//1. 학생 정보 초기화
		//2. 학생 정보 전체 조회
		//3. 학생 정보 검색 조회(이름)
		//4. 학생 정보 추가
		//5. 학생 정보 삭제(이름)
		//6. 프로그램 종료
		StudentController sCon = new StudentController();
		sCon.start();
//		StudentDAO dao = new StudentDAO();
//		ArrayList<StudentDTO> ar = dao.init();
//		StudentDTO std = dao.findByName(ar);
//		System.out.println(std.getName());
//		System.out.println(std.getAvg());
		//향상된 for문
//		for(StudentDTO studentDTO:ar) {
//			System.out.println(studentDTO.getName());
//		}
//		int nums[] = new int[3];
//		for(int n:nums) {
//			System.out.println(n);
//		}
	}
}
