package com.iu.api4.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Random;

public class Server2 {
	public static void main(String[] args) {
		//client 접속 대기
		//1. 점심메뉴중 하나 랜덤으로 골라서 전송
		//2. 저녁메뉴중 하나 랜덤으로 골라서 전송
		//3. 종료
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String str;
		boolean check = true;
		Calendar c = Calendar.getInstance();
		Random r = null;
		String msg = null;
		String lunchL[] = {"짜장면", "짬뽕", "탕수육", "유린기"};
		String dinnerL[] = {"떡볶이", "순대", "튀김", "김밥"};
		
		try {
			ss = new ServerSocket(8282);
			System.out.println("서버 실행");
			sc = ss.accept();
			System.out.println("클라이언트 접속");
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			
			while(check) {
				r = new Random(c.getTimeInMillis());
				str = br.readLine();
				int select = Integer.parseInt(str);
				switch(select) {
				case 1 :
					msg = "점심 메뉴 추천 : " + lunchL[r.nextInt(lunchL.length)];
					System.out.println(msg);
					break;
				case 2 :
					msg = "저녁 메뉴 추천 : " + dinnerL[r.nextInt(lunchL.length)];
					System.out.println(msg);
					break;
				case 3 :
					System.out.println("연결 종료");
					msg = "연결 종료";
					check = false;
					break;
				default :
					System.out.println("잘못 입력함");
					msg = "잘못 입력함";
					break;
				}
				if(check) {
					bw.write(msg + "\r\n");
					bw.flush();
				}
			}
			
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
