package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDAO {
	private StringBuffer sb;
	private Scanner sc = new Scanner(System.in);
	public StudentDAO() {
		this.sb = new StringBuffer();
		sb.append("iu-1-90-60-70-");
		sb.append("winter-2-86-84-75-");
		sb.append("suji, 3, 89, 74, 87 ");
		sb.append("choa, 4, 72, 25, 99");
	}
	//학생 정보 삭제
	public int removeStudent(ArrayList<StudentDTO> ar) {
		int result = 0; // 삭제 확인용 변수 0->실패 1->성공
		System.out.println("삭제할 이름 입력");
		String name = sc.next();
//		for(int i = 0; i < ar.size(); i ++) {
//			if(ar.get(i).getName().equals(name)) {
//				ar.remove(i);
//				result = 1;
//				break;
//			}
//		}
		for(StudentDTO std : ar) {
			if(std.getName().equals(name)) {
				ar.remove(std);
				result = 1;
				break;
			}
		}
		return result;
	}
	
	//학생 정보 추가
	public void addStudent(ArrayList<StudentDTO> ar) {
		StudentDTO studentDTO = new StudentDTO();
		System.out.println("이름을 입력하세요.");
		studentDTO.setName(sc.next());
		System.out.println("번호를 입력하세요.");
		studentDTO.setNumber(sc.nextInt());
		System.out.println("국어 성적을 입력하세요.");
		studentDTO.setKor(sc.nextInt());
		System.out.println("영어 성적을 입력하세요.");
		studentDTO.setEng(sc.nextInt());
		System.out.println("수학 성적을 입력하세요.");
		studentDTO.setMath(sc.nextInt());
		
		studentDTO.setSum(studentDTO.getKor() + studentDTO.getEng() + studentDTO.getMath());
		studentDTO.setAvg(studentDTO.getSum() / 3.0);
		ar.add(studentDTO);
	}
	
	//학생 정보 검색
	public StudentDTO findByName(ArrayList<StudentDTO> ar) {
		System.out.println("이름을 입력");
		String str = sc.next();
		StudentDTO st = null;
		for(StudentDTO sdt : ar) {
			if(sdt.getName().equals(str)) {
				st = sdt;
				break;
			}
		}
		return st;
	}
	
	
	//학생 정보 초기화
	public ArrayList<StudentDTO> init() {
		String data = this.sb.toString();
		data = data.replace(" ", "-");
		data = data.replace(",", "");
		StringTokenizer st = new StringTokenizer(data, "-");
		ArrayList<StudentDTO> arr = new ArrayList<StudentDTO>();
		while(st.hasMoreTokens()) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNumber(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setSum(studentDTO.getKor() + studentDTO.getEng() + studentDTO.getMath());
			studentDTO.setAvg(studentDTO.getSum() / 3.0);
			arr.add(studentDTO);
		}
		return arr;
	}
	
}
