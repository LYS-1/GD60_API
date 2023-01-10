package com.iu.api2.collections.sample;

import java.util.ArrayList;



public class CollectionMain {
	public static void main(String[] args) {
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		
		ArrayList<Parents> ar = new ArrayList<>();
		ar.add(c1);
		ar.add(c2);
		
		System.out.println(ar.get(0) instanceof Child2);
		
//		ArrayList<? extends Parents> ar2 = new ArrayList<Parents>();
//		ar2.add(c2);
		ArrayList<? super Parents> ar3 = new ArrayList<Parents>();
		ar3.add(c2);		
	}
}
