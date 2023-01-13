package com.iu.api4.network.ex2;

import java.util.ArrayList;

public class ServerMain {

	public static void main(String[] args)  {
		//프로그램 시작, Test
		try {
			new StudentController().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}