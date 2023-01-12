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
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner s = new Scanner(System.in);
		String msg = null;

		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 대기");
			sc = ss.accept();
			System.out.println("접속 성공");
				
			while(true) {
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
					
				msg = br.readLine();
				System.out.println("Client : " + msg);
				if(msg != null && msg.toUpperCase().equals("Q")) {
					break;
				}
					
				System.out.println("Client에 보낼 메세지");
				msg = s.next();
				
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
					
				bw.write(msg + "\r\n");
				bw.flush();
				System.out.println("전송 성공");
				if(msg != null && msg.toUpperCase().equals("Q")) {
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
//				sc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

