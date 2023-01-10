package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

	public void start() {
		boolean check = true;
		int act = 0;
		String name;
		StudentDAO sDAO = new StudentDAO();
		ArrayList<StudentDTO> sdt = sDAO.init();
		StudentView sv = new StudentView();
		while(check) {
			System.out.println("행동을 선택해주세요. 1. 학생 정보 초기화 2. 학생 정보 전체 조회 "
					+ "3. 학생 정보 검색 조회(이름) 4. 학생 정보 추가 5. 학생 정보 삭제(이름) 6. 프로그램 종료");
			Scanner sc = new Scanner(System.in);
			act = sc.nextInt();
			switch(act) {
			case 1:
				System.out.println("학생 정보 초기화");
				sdt = sDAO.init();
				break;
			case 2:
				System.out.println("학생 전체 정보 출력");
				sv.viewAll(sdt);
				break;
			case 3:
				System.out.println("학생 정보 검색");
				sDAO.findStudent(sdt);
				break;
			case 4:
				System.out.println("학생 정보 추가");
				sDAO.addStudent(sdt);
				break;
			case 5:
				System.out.println("학생 정보 삭제");
				sDAO.delStudent(sdt);
				break;
			case 6:
				System.out.println("프로그램 종료");
				check = false;
				break;
			default :
				System.out.println("다시 선택");
				break;
			}
		}
	}
	
}
