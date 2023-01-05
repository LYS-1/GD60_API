package com.iu.api1.objects;

public class StringEx3 {
	public static void main(String[] args) {
		String email = "a@bc@123@gamil.com";
		int idx = email.lastIndexOf("@");
		String id = "";
		System.out.println(idx);
		System.out.println(email.length());
		
		for(int i = 0; i < idx; i ++) {
			char ch = email.charAt(i);
			id = id + ch;
		}
		System.out.println(id);
		
		System.out.println("Before Email : " + email);
		email = email.replace('@', '_');
		System.out.println("After Email : " + email);
		
		String str = " a";
		String str2 = null;
		System.out.println("STR : " + str2.length());
	}
}
