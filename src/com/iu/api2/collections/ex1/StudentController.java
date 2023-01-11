package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	private Scanner sc;
	private StudentDAO sDAO;
	private StudentView sView;
	private ArrayList<StudentDTO> ar;
	public StudentController() {
		sc = new Scanner(System.in);
		sDAO = new StudentDAO();
		sView = new StudentView();
		ar = sDAO.init();
	}
	public void start() {
		//1. 학생 정보 초기화
		//2. 학생 정보 전체 조회
		//3. 학생 정보 검색 조회(이름)
		//4. 학생 정보 추가
		//5. 학생 정보 삭제(이름)
		//6. 프로그램 종료
		boolean check = true;
		while(check) {
			System.out.println("1. 학생 정보 초기화");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 검색 조회(이름)");
			System.out.println("4. 학생 정보 추가");
			System.out.println("5. 학생 정보 삭제(이름)");
			System.out.println("6. 프로그램 종료");
			System.out.println("7. 학생 정보 백업");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				ar = sDAO.init();
				break;
			case 2 :
				sView.view(ar);
				break;
			case 3 :
				StudentDTO sDTO = sDAO.findByName(ar);
				if(sDTO != null) {
					sView.view(sDTO);
				}else {
					sView.view("찾는 학생이 없습니다.");
				}
				break;
			case 4 :
				sDAO.addStudent(ar);
				break;
			case 5 :
				select = sDAO.removeStudent(ar);
				if(select == 1) {
					sView.view("학생 정보 삭제 성공");
				}else {
					sView.view("학생 정보 삭제 실패");
				}
				break;
			case 6 :
				check = false;
				break;
			case 7:
				break;
			default : 
				System.out.println("잘못된 번호");
				break;
			}
		}
	}
	
}
