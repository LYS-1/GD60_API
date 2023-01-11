package com.iu.api3.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMain2 {
	public static void main(String[] args) {
		File f = new File("C:\\filetest", "test.txt");
		System.out.println(f.exists());
		
		//파일에 내용 작성
		String name = "suji";
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(name + "\r\n");
			fw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
