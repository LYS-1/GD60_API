package com.iu.api2.collections;

import java.util.ArrayList;

public class ListMain {
	public static void main(String[] args) {
		//순서가 유지되고 값의 중복을 허용, 배열 기반
		int arr[] = new int [3];
		ArrayList ar = new ArrayList();
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		//add 새로운 데이터 추가
		ar.add(10);
		ar.add(11);
		ar.add(12);
		for( int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
		System.out.println("======================");
		ar.add(1, 8);
		ar.remove(0);
		ar.set(2, 9);
		for( int i = 0; i < ar.size(); i ++) {
			System.out.println(ar.get(i));
		}
	}
}
