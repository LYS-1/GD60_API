package com.iu.api4.network.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient {
	public static void main(String[] args) {
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner s = new Scanner(System.in);
		String str = null;
		StudentController stCon = null;
		String dummy;
		String many;
		try {
			sc = new Socket("localhost", 8282);
			System.out.println("접속을 환영합니다.");
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			stCon = new StudentController(bw);
			int count = 0;
			boolean repeat = true;
			while(repeat) {
				System.out.println("1. 학생 정보 초기화");
				System.out.println("2. 학생 정보 전체 조회");
				System.out.println("3. 학생 정보 검색 조회(이름)");
				System.out.println("4. 학생 정보 추가");
				System.out.println("5. 학생 정보 삭제(이름)");
				System.out.println("6. 학생 정보 저장");
				System.out.println("7. 시스템 종료");
				String input = s.next();
				bw.write(input + "\r\n");
				bw.flush();
				int check = Integer.parseInt(input);
				switch(check) {
				case 1:
					many = br.readLine();
					System.out.println(many);
					break;
				case 2:
					many = br.readLine();
					count = Integer.parseInt(many);
					for(int i = 0 ; i < count; i ++) {
						many = br.readLine();
						System.out.println(many);
						many = br.readLine();
						System.out.println(many);
					}
					break;
				case 3:
					System.out.println("찾는 학생 정보 입력");
					dummy = s.next().toUpperCase();
					bw.write(dummy + "\r\n");
					bw.flush();
					many = br.readLine();
//					many = br.readLine();
					System.out.println(many);
					break;
				case 4:
					System.out.println(br.readLine());
					dummy = s.next().toUpperCase();
					bw.write(dummy + "\r\n");
					bw.flush();
					System.out.println(br.readLine());
					dummy = s.next();
					bw.write(dummy + "\r\n");
					bw.flush();
					System.out.println(br.readLine());
					dummy = s.next();
					bw.write(dummy + "\r\n");
					bw.flush();
					System.out.println(br.readLine());
					dummy = s.next();
					bw.write(dummy + "\r\n");
					bw.flush();
					System.out.println(br.readLine());
					dummy = s.next();
					bw.write(dummy + "\r\n");
					bw.flush();
					System.out.println(br.readLine());
					break;
				case 5:
					many = br.readLine();
					System.out.println(many);
					bw.write(s.next() + "\r\n");
					bw.flush();
					many = br.readLine();
					System.out.println(many);
					break;
				case 6:
					break;
				case 7:
					many = br.readLine();
					System.out.println(many);
					repeat = false;
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
