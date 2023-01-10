package com.iu.api2.collections;

import java.util.HashMap;
import java.util.Iterator;


public class MapMain {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("k1", "V1");
		map.put("k2", "V2");
		map.put("k3", "V3");
		map.put("k2", "v2Re");
		//데이터 key로 조회하기
		String s = map.get("k3");
		System.out.println(s);
		//삭제
		s = map.remove("k2");
		System.out.println(s);
		boolean check = map.containsKey("k1");
		System.out.println(check);
		check = map.containsValue("V1");
		System.out.println(check);
		
		
		Iterator<String> it= map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("key : " + key);
			String value = map.get(key);
			System.out.println("value : " + value);
		}
		
		//전체삭제
		map.clear();
		System.out.println(map);
		//반복
		//1. key들의 정보를 알아야함
		//	key들을 set으로 변환
		//	set을 iterator로 변환
		
		
	}
}
