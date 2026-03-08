package com.MulitTreadin;

import java.util.concurrent.Semaphore;

class SharedResources {
	Semaphore semaphore = new Semaphore(3);
	public void resource(String threadName) {
		System.out.println(threadName + "Waiting");
		
		try {
			semaphore.acquire();
			System.out.println(threadName + "Aqcuire");
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println(threadName + "Released");

		}
	}
}

public class SemaphoreThread extends Thread {

	SharedResources sharedResources;

	public SemaphoreThread(SharedResources sharedResources, String name) {
		super(name);
		this.sharedResources = sharedResources;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			sharedResources.resource(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {

		SharedResources sharedResources = new SharedResources();

		for (int i = 1; i <= 5; i++) {
			new SemaphoreThread(sharedResources, "Thread-" + i).start();
		}
	}
}
