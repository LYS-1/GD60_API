package com.iu.api2.token;

import java.util.StringTokenizer;

public class StringToken1 {
	public static void main(String[] args) {
		String nations = "Korea, 서울, USA, 워싱턴, UK, 런던, Japan, 도쿄";
		String n[] = nations.split(", ");
		
		for(int i = 0; i < n.length; i++) {
			NationDTO nationDTO = new NationDTO();
			nationDTO.setName(n[i]);
			nationDTO.setCity(n[++i]);
		}
		
		
		StringTokenizer st = new StringTokenizer(nations, ", ");
		int count = 1;
		while(st.hasMoreTokens()) {
			NationDTO nationDTO = new NationDTO();
			String t1 = st.nextToken();
			nationDTO.setName(t1);
			String t2 = st.nextToken();
			nationDTO.setName(t2);
			
			
			
		}
	}
	
}
