package com.iu.api4.network.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDAO_Server {
	private ArrayList<StudentDTO> studentArr = null;
	StudentDTO stDTO = null;
	String str = null;
	int result = 0;
	Scanner sc = new Scanner(System.in);
	BufferedWriter bWriter;
	BufferedReader bReader;
	int dummy;
	
	public StudentDAO_Server(BufferedWriter bw, BufferedReader br) {
		bWriter = bw;
		bReader = br;
	}
	
	//학생 정보 저장
	public void saveStudent(ArrayList<StudentDTO> stArr) {
		File check = new File("C:\\filetest", "student1.txt");
		if(check.exists()) {
			System.out.println("삭제");
			check.delete();
		}
		File f = new File("C:\\filetest", "student1.txt");
		String str;
		ArrayList<String> arrayS = new ArrayList<>();
		
		for(int i = 0 ; i < stArr.size(); i ++) {
			str = stArr.get(i).getName() + " - " + stArr.get(i).getNumber() + " - " + stArr.get(i).getKor() + " - " 
						+ stArr.get(i).getEng() + " - " + stArr.get(i).getMath();
			arrayS.add(str);
		}
		try {
			FileWriter fw = new FileWriter(f, true);
			for(int i = 0 ; i < arrayS.size(); i ++) {
				str = arrayS.get(i);
				fw.write(str + "\r\n");
				fw.flush();
			}
			fw.close();
			bWriter.write("정보 저장 완료");
			bWriter.flush();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				bWriter.write("오류");
				bWriter.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Server에서 오류");
			}
		}
	}
	
	//삭제
	public int removeStudent(ArrayList<StudentDTO> stArr) {
		try {
			bWriter.write("삭제할 이름 입력 \r\n");
			bWriter.flush();
			String name = bReader.readLine().toUpperCase();
			for(StudentDTO std : stArr) {
				if(std.getName().equals(name)) {
					stArr.remove(std);
					result = 1;
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	//추가
	public void addStudent(ArrayList<StudentDTO> stArr) {
		StudentDTO studentDTO = new StudentDTO();
		try {
			bWriter.write("이름을 입력하세요." + "\r\n");
			bWriter.flush();
			str = bReader.readLine();
			studentDTO.setName(str);
			bWriter.write("번호를 입력하세요." + "\r\n");
			bWriter.flush();
			str = bReader.readLine();
			dummy = Integer.parseInt(str);
			studentDTO.setNumber(dummy);
			bWriter.write("국어 성적을 입력하세요." + "\r\n");
			bWriter.flush();
			str = bReader.readLine();
			dummy = Integer.parseInt(str);
			studentDTO.setKor(dummy);
			bWriter.write("영어 성적을 입력하세요." + "\r\n");
			bWriter.flush();
			str = bReader.readLine();
			dummy = Integer.parseInt(str);
			studentDTO.setEng(dummy);
			bWriter.write("수학 성적을 입력하세요." + "\r\n");
			bWriter.flush();
			str = bReader.readLine();
			dummy = Integer.parseInt(str);
			studentDTO.setMath(dummy);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		stArr.add(studentDTO);
	}
	
	//검색
	public StudentDTO findByName(ArrayList<StudentDTO> stArr, String input) {
		str = input.toUpperCase();
		stDTO = null;
		for(int i = 0; i < stArr.size(); i ++) {
			if(str.equals(stArr.get(i).getName())) {
				stDTO = stArr.get(i);
			}
		}
		return stDTO;
	}
	
	//초기화
	public ArrayList<StudentDTO> init() {
//		System.out.println("Server init 실행");
		File f = new File("C:\\filetest", "student1.txt");
//		ArrayList<String> stArray = new ArrayList<String>();
		studentArr = new ArrayList<StudentDTO>();
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while(true) {
				str = br.readLine();
				if(str == null) {
					break;
				}
				str = str.replace(" ", "");
				str = str.replace("-", ",");
				StringTokenizer st = new StringTokenizer(str, ",");
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setName(st.nextToken().toUpperCase());
				studentDTO.setNumber(Integer.parseInt(st.nextToken()));
				studentDTO.setKor(Integer.parseInt(st.nextToken()));
				studentDTO.setEng(Integer.parseInt(st.nextToken()));
				studentDTO.setMath(Integer.parseInt(st.nextToken()));
				
				studentArr.add(studentDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println("init 빠져나감");
		return studentArr;
	}
}