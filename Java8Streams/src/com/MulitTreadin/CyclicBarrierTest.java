package com.MulitTreadin;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest extends Thread {
	CyclicBarrier barrier;

	public CyclicBarrierTest(CyclicBarrier barrier, String name) {
		super(name);
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(getName() + " is performing task");
			Thread.sleep(2000);
			System.out.println(getName() + " waiting at barrier");
			barrier.await(); // wait for other threads
			System.out.println(getName() + " crossed the barrier");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
		for (int i = 0; i < 5; i++) {
			new CyclicBarrierTest(cyclicBarrier, "Thread " + i).start();

		}
	}
}
