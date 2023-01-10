package com.iu.api2.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionMain {
	public static void main(String[] args) {
		ArrayList<Integer> ar1 = new ArrayList<>();
		ArrayList<Integer> ar2 = new ArrayList<>();
		ar1.add(1);
		ar2.add(2);
		ArrayList<ArrayList<Integer>> intList = new ArrayList<>();
		intList.add(ar1);
		intList.add(ar2);
		for(ArrayList<Integer> a : intList) {
			System.out.println(a);
		}
		HashMap<String, ArrayList<Integer>> hsIntMap= new HashMap<>();
		hsIntMap.put("k1", ar1);
		hsIntMap.put("k2", ar2);
		System.out.println(hsIntMap);
	}
}
