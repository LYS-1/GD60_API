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

public class Client1 {
	public static void main(String[] args) {
		// 127.0.0.1 , localhost => 본인 컴퓨터
		Socket socket = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String msg = null;
		boolean check = true;
		Scanner s = new Scanner(System.in);
		try {
			socket = new Socket("192.168.1.80", 8282);
			System.out.println("서버 접속 성공");
			while(check) {
				//0,1
				os = socket.getOutputStream();
				//char
				ow = new OutputStreamWriter(os);
				//Stream
				bw = new BufferedWriter(ow);
				
				System.out.println("서버에 보낼 메세지 입력");
				msg = s.next();
				bw.write(msg + "\r\n");
				bw.flush();
				if(msg != null && msg.toUpperCase().equals("Q")) {
					break;
				}
				
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				
				msg = br.readLine();
				System.out.println("Server : " + msg);
				if(msg != null && msg.toUpperCase().equals("Q")) {
					break;
				}
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
					socket.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
