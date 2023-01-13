package com.iu.api4.network.ex1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	private StudentDAO sDAO;
	private StudentView sView;
	private ArrayList<StudentDTO> ar;
	private BufferedWriter bWriter;
	private Scanner s = new Scanner(System.in);
	public StudentController(BufferedWriter bw) {
		sDAO = new StudentDAO(bw);
		sView = new StudentView(bw);
		ar = sDAO.init();
		bWriter = bw;
	}
	public boolean start(int input) { //OutputStream os,	OutputStreamWriter ow, 
		boolean check = true;
		System.out.println("1. 학생 정보 초기화");
		System.out.println("2. 학생 정보 전체 조회");
		System.out.println("3. 학생 정보 검색 조회(이름)");
		System.out.println("4. 학생 정보 추가");
		System.out.println("5. 학생 정보 삭제(이름)");
		System.out.println("6. 학생 정보 저장");
		System.out.println("7. 시스템 종료");

		int select = input;
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
				sDAO.saveStudent(ar);
				break;
			case 7 :
				check = false;
				break;
			default : 
				System.out.println("잘못된 번호");
				break;
			}

		return check;
	}
}
