package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
	StudentDTO sDTO = new StudentDTO();
	Scanner sc = new Scanner(System.in);
	
	public void viewAll(ArrayList<StudentDTO> sdt) {

		for( int i = 0 ; i < sdt.size(); i ++) {
			System.out.println("학생의 이름 " + sdt.get(i).getName());
			System.out.println("학생의 번호 " + sdt.get(i).getNumber());
			System.out.println("학생의 국어 성적 " + sdt.get(i).getKor());
			System.out.println("학생의 영어 성적 " + sdt.get(i).getEng());
			System.out.println("학생의 수학 성적 " + sdt.get(i).getMath());
			System.out.println("학생의 총성적 " + sdt.get(i).getSum());
			System.out.println("학생의 평균 성적 " + sdt.get(i).getAvg());
			System.out.println("========================================");
		}
	}
}
