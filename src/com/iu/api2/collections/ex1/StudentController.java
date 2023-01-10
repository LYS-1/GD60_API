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
				sdt = sDAO.init();
				break;
			case 2:
				sv.view(sdt);
				break;
			case 3:
				int result = sDAO.findStudent(sdt);
				if(result == 0) {
					sv.view("학생 정보가 없습니다.");
				}else {
					sv.view(sdt.get(result));
				}
				break;
			case 4:
				sDAO.addStudent(sdt);
				break;
			case 5:
				sDAO.delStudent(sdt);
				break;
			case 6:
				check = false;
				break;
			default :
				break;
			}
		}
	}
	
}
