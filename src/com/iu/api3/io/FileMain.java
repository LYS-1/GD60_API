package com.iu.api3.io;

import java.io.File;

public class FileMain {
	public static void main(String[] args) {
		//1.java.io.file 클래스
		//	Hdd에 파일과 폴더의 정보를 담으려고하는 클래스
		File file = new File("C:\\");
		
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.length());
		System.out.println(file.exists());
		if(!file.exists()) {file.mkdirs();}
		
		String [] files = file.list();
		for(String name : files) {
			System.out.println(name);
			File f = new File("C:\\" + name);
			System.out.println(f.isDirectory());
		}
	}
}
