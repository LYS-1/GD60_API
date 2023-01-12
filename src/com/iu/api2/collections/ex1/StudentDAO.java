package com.iu.api2.collections.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
	//학생 정보 백업 현재 시간을 파일명으로
	public void saveStudent(ArrayList<StudentDTO> ar) {
		File f = new File("C:\\filetest\\timeSave", Calendar.getInstance().getTimeInMillis() +".txt");
		ArrayList<String> arrayS = new ArrayList<>();
		String str;
		for(int i = 0 ; i < ar.size(); i ++) {
			str = ar.get(i).getName() + " - " + ar.get(i).getNumber() + " - " + ar.get(i).getKor() + " - " 
						+ ar.get(i).getEng() + " - " + ar.get(i).getMath();
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
				System.out.println("정보 저장 완료");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("오류");
			}
	}
	//한파일로만
	public void saveTest(ArrayList<StudentDTO> ar) {
		File check = new File("C:\\filetest", "student.txt");
		if(check.exists()) {
			System.out.println("삭제");
			check.delete();
		}
		File f = new File("C:\\filetest", "student.txt");
		ArrayList<String> arrayS = new ArrayList<>();
		String str;
		for(int i = 0 ; i < ar.size(); i ++) {
			str = ar.get(i).getName() + " - " + ar.get(i).getNumber() + " - " + ar.get(i).getKor() + " - " 
						+ ar.get(i).getEng() + " - " + ar.get(i).getMath() + "\r\n";
			arrayS.add(str);
		}
		FileWriter fw = null;
			try {
				fw = new FileWriter(f, false);
				for(int i = 0 ; i < arrayS.size(); i ++) {
					str = arrayS.get(i);
					fw.write(str);
					fw.flush();
				}
				System.out.println("정보 저장 완료");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
//		String data = this.sb.toString();
		//1. 파일 정보 file
		File f = new File("C:\\filetest", "student.txt");
		//2. 파일 내용 읽기 연결
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<StudentDTO> arr = new ArrayList<StudentDTO>();
		File getF = new File("C:\\filetest\\timeSave");
		String names[] = getF.list();
		
		long max = 0;
		for(String name :names) {
			name = name.substring(0, name.lastIndexOf("."));
			long date = Long.parseLong(name);
			if(date > max) {
				max = date;
			}
		}
		f = new File("C:\\filetest\\timeSave", max + ".txt");
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String data = null;
			while((data=br.readLine()) != null) {
				data = data.replace(" ", "-");
				data = data.replace(",", "");
				StringTokenizer st = new StringTokenizer(data, "-");
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
//		this.saveTest(arr);
		return arr;
	}
	
}
