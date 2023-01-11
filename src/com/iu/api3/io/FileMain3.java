package com.iu.api3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileMain3 {
	public static void main(String[] args) {
		File f = new File("C:\\filetest", "test.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String s = br.readLine();
				if(s == null) {
					break;
				}
				System.out.println(s);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
