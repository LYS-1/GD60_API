package com.iu.api1.strings;

public class StringBuffer1 {
	public static void main(String[] args) {
		//stringbuffer는 string이 아님
		StringBuffer sb = new StringBuffer("Hello");
		char ch[] = {'a', 'b', 'c'};
		sb.append("World");
		
		System.out.println(sb);
		
		//참조변수 호출하려면 .toString()  : 클래스명@객체주소
		//toString()을 오버라이딩했다
		//변수에는 같은 데이터타입만 대입가능
		String str = sb.substring(0);
		System.out.println(str);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println(String.valueOf(false));
		System.out.println(String.valueOf('a'));
		System.out.println(String.valueOf(ch));
		System.out.println(String.valueOf(ch, 0, 0));
		str = String.valueOf(2123);
		System.out.println(str);
		str = 123 +"";
		System.out.println(str);
		str = String.valueOf(3.14);
		System.out.println(str);
	}
}
