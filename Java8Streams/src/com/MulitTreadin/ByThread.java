package com.MulitTreadin;

import java.util.Iterator;

public class ByThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" "+i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		
		for(int i=0;i<5;i++){
			new ByThread().start();
		}
		
	}

}
