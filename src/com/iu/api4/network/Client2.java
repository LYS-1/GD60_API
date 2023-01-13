package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		//1. 서버 접속 시도
		//2. 1. 점심, 2. 저녁, 3. 종료
		//3. 1,2,3 고르기
		//4. 1번 : 서버에서 점심 메뉴 중 하나를 보내줌, 출력
		//4. 2번 : 서버에서 저녁 메뉴 중 하나를 보내줌, 출력
		//4. 3번 : 종료
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner s = new Scanner(System.in);
		String str = null;
		
		try {
			sc = new Socket("192.168.1.80", 8282);
			System.out.println("접속을 환영합니다.");
			while(true) {
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				
				System.out.println("1. 점심 메뉴 추천 2. 저녁 메뉴 추천 3. 종료");
				str = s.next();
				
				bw.write(str + "\r\n");
				bw.flush();
				
				if(Integer.parseInt(str) == 3) {
					System.out.println("시스템 종료");
					break;
				}
				
				str = br.readLine();
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
