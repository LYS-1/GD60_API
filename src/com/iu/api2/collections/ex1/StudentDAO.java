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
		sb.append("suji, 3, 89, 74, 87,");
		sb.append("choa, 4, 72, 25, 99,");
		
		
	}
	//학생 정보 초기화
	public ArrayList<StudentDTO> init() {
		String str = sb.toString();
		str = str.replace("-", ",");
		str = str.replace(", ", ",");
		StringTokenizer st = new StringTokenizer(str, ",");
		ArrayList<StudentDTO> sdt = new ArrayList<StudentDTO>();
		while(st.hasMoreTokens()) {
			StudentDTO sDTO = new StudentDTO();
			sDTO.setName(st.nextToken().toUpperCase());
			sDTO.setNumber(Integer.parseInt(st.nextToken()));
			sDTO.setKor(Integer.parseInt(st.nextToken()));
			sDTO.setEng(Integer.parseInt(st.nextToken()));
			sDTO.setMath(Integer.parseInt(st.nextToken()));
			sDTO.setSum(sDTO.getKor() + sDTO.getEng() + sDTO.getMath());
			sDTO.setAvg(sDTO.getSum() / 3.0);
			sdt.add(sDTO);
		}
		return sdt;
	}
	//학생 정보 추가
	public void addStudent(ArrayList<StudentDTO> sdt) {
		
		StudentDTO sDTO = new StudentDTO();
		System.out.println("이름을 입력하세요.");
		sDTO.setName(sc.next().toUpperCase());
		System.out.println("번호를 입력하세요.");
		sDTO.setNumber(sc.nextInt());
		System.out.println("국어 성적을 입력하세요.");
		int sKor = sc.nextInt();
		sDTO.setKor(sKor);
		System.out.println("영어 성적을 입력하세요.");
		int sEng = sc.nextInt();
		sDTO.setEng(sEng);
		System.out.println("수학 성적을 입력하세요.");
		int sMath = sc.nextInt();
		sDTO.setMath(sMath);
		
		int a = sDTO.getKor() + sDTO.getEng() + sDTO.getMath();
		double b = a / 3;
		sDTO.setSum(a);
		sDTO.setAvg(b);
		
		sdt.add(sDTO);
	}
	//학생 정보 삭제
	public void delStudent(ArrayList<StudentDTO> sdt) {
		int id = 0;
		System.out.println("이름을 입력하세요");
		String s = sc.next().toUpperCase();
		for( int i = 0; i < sdt.size(); i ++) {
			if(sdt.get(i).getName().equals(s.toUpperCase())) {
				sdt.remove(i);
				id = 1;
				break;
			}
		}
		if ( id == 0 ) {
			System.out.println("없는 학생입니다.");
		}else {
			System.out.println("삭제되었습니다.");
		}
	}
	//학생 정보 찾기
	public int findStudent(ArrayList<StudentDTO> sdt) {
		System.out.println("이름을 입력하세요.");
		String s = sc.next().toUpperCase();
		int id = 0;
		for( int i = 0; i < sdt.size(); i ++) {
			if(sdt.get(i).getName().equals(s)) {
				id = i;
				break;
			}
		}
		return id;
	}
}
