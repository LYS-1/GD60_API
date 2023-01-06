package com.iu.api1.strings;

import java.util.Scanner;

public class StringEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String names[] = {"jpg", "jpeg", "gif", "png"};
		System.out.println("파일명을 입력");
		String fileName = sc.next();
		int idx = fileName.lastIndexOf('.');
		String result = fileName.substring(idx + 1);
		
		switch(result) {
		case "jpg":
			System.out.println(names[0]);
			break;
		case "jpeg":
			System.out.println(names[1]);
			break;
		case "gif":
			System.out.println(names[2]);
			break;
		case "png":
			System.out.println(names[3]);
			break;
			
		}
		
		boolean check = true;
		for(int i = 0; i < names.length; i ++) {
			if(names[i].equals(result)) {
				System.out.print(names[i] + "이미지 파일");
				check = false;
				break;
			}
		}
		if(check) {
			System.out.println("파일명 오류");
		}
	}
}
