package com.iu.api1.objects;

public class ObjectStudy {
	public static void main(String[] args) {
		Object object = new Object();
		
		int a = object.hashCode();
		System.out.println(a);
		
		String r = object.toString();
		System.out.println(r);
		System.out.println(object);
		
		Child child = new Child();
		
		Object obj = new Object();
		System.out.println(object == obj);
		boolean check = object.equals(obj);
		System.out.println(check);
		System.out.println(child.toString());
		System.out.println(child);
		System.out.println(child.hashCode());
		
		Object o = child;
	}
}
