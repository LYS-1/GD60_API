package com.iu.api1.strings;

import java.util.Scanner;

public class StringEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String names[] = {"jpg", "jpeg", "gif", "png"};
		System.out.println("파일명을 입력");
		String fileName = sc.next();
		boolean check = false;
		//System.out.println(fileName.substring(fileName.lastIndexOf('.') + 1));
		for(int i = 0; i < names.length; i ++) {
			if(names[i].equals(fileName.substring(fileName.lastIndexOf('.')+ 1))) {
				check = true;
				System.out.print(names[i] + " ");
				break;
			}
		}
		if(check == true) {
			System.out.println("이미지 파일");
		}else {
			System.out.println("파일명 오류");
		}
	}
}
