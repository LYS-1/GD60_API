package com.iu.api4.network.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentControllerServer {
	private int act;
	private ArrayList<StudentDTO> stArr;
	private StudentDAO_Server sDAO_s = null;
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	private String str;
	private StudentDTO stDTO = null;
	


	public StudentControllerServer(BufferedWriter bw, BufferedReader br) {
		this.bw = bw;
		this.br = br;
		sDAO_s = new StudentDAO_Server(bw, br);
//		System.out.println("초기실행");
		stArr = sDAO_s.init();
	}
	
	
	public void startSCS(int select) {
		switch (select) {
		case 1:
			stArr = sDAO_s.init();
//			System.out.println("초기화 성공.");
			try {
				bw.write("초기화 성공. \r\n");
				bw.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
//			System.out.println("정보 전체 출력");
			try {
				String s = Integer.toString(stArr.size());
				bw.write(s + "\r\n");
				bw.flush();
				for(int i = 0 ; i < stArr.size(); i ++) {
					str = stArr.get(i).getName() + " - " + stArr.get(i).getNumber() + " - " + stArr.get(i).getKor() + " - " 
								+ stArr.get(i).getEng() + " - " + stArr.get(i).getMath();
					bw.write(str + "\r\n");
					bw.flush();
					bw.write("========================\r\n");
					bw.flush();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
//			System.out.println("학생 정보 검색");
			try {
				String dummy = br.readLine();
				stDTO = sDAO_s.findByName(stArr, dummy);
				str = stDTO.getName() + " - " + stDTO.getNumber() + " - " + stDTO.getKor() + " - " 
								+ stDTO.getEng() + " - " + stDTO.getMath();
				bw.write(str + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			sDAO_s.addStudent(stArr);
			try {
				bw.write("학생 정보 추가 성공 \r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			int dummy = sDAO_s.removeStudent(stArr);
			try {
				if(dummy == 1) {
					bw.write("학생 정보 삭제 성공 \r\n");
					bw.flush();
				}else {
					bw.write("학생 정보 삭제 실패 \r\n");
					bw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			sDAO_s.saveStudent(stArr);
			try {
				bw.write("학생 정보 백업 성공 \r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("시스템 종료");
			try {
				bw.write("시스템 종료 \r\n");
				bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default :
			try {
				bw.write("잘못된 입력입니다.");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}
}
