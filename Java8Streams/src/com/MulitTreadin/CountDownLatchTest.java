package com.MulitTreadin;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends Thread {
	CountDownLatch countDownLatch;
	String str;

	public CountDownLatchTest(CountDownLatch countDownLatch, String str) {
		this.countDownLatch = countDownLatch;
		this.str = str;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " Started ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println(Thread.currentThread().getName() + " Started Count " + countDownLatch.getCount());
		countDownLatch.countDown();
		System.out.println(Thread.currentThread().getName() + " Ending Count " + countDownLatch.getCount());
		System.out.println(Thread.currentThread().getName() + " Ended ");

	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		for (int i = 0; i < 3; i++) {
			new CountDownLatchTest(countDownLatch, countDownLatch + " Worker " + i).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName() + " All finished ");
	}

}
