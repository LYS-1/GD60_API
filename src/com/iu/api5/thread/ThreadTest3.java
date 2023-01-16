package com.iu.api5.thread;

public class ThreadTest3 implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.t3();
		
	}
	
	public void t3() {
		for(int i = 0 ; i < 25; i ++) {
			System.out.println("Hello : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
