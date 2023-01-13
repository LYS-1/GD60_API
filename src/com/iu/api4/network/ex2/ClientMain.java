package com.iu.api4.network.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) throws Exception{
		
		Socket sc = new Socket("localhost", 8282);
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		is = sc.getInputStream();
		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);
		
		os = sc.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		
		bw.write("1-\r\n");
		bw.flush();
		
		String str= br.readLine();
		System.out.println(str);
	}
}
