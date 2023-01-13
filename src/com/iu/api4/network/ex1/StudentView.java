package com.iu.api4.network.ex1;

import java.io.BufferedWriter;
import java.util.ArrayList;


public class StudentView {
	BufferedWriter bWriter;
	public StudentView(BufferedWriter bw) {
		bWriter = bw;
	}
	public void view(ArrayList<StudentDTO> stArr) {
		for(StudentDTO a :stArr) {
			System.out.println("이름 : " + a.getName());
			System.out.println("번호 : " + a.getNumber());
			System.out.println("국어 점수 : " + a.getKor());
			System.out.println("영어 점수 : " + a.getEng());
			System.out.println("수학 점수 : " + a.getMath());
			System.out.println("=============================");
		}
	}
	public void view(StudentDTO dto) {
		System.out.println("이름 : " + dto.getName());
		System.out.println("번호 : " + dto.getNumber());
		System.out.println("국어 점수 : " + dto.getKor());
		System.out.println("영어 점수 : " + dto.getEng());
		System.out.println("수학 점수 : " + dto.getMath());
	}
	public void view(String str) {
		System.out.println(str);
	}
}
