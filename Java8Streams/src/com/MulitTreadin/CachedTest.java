package com.MulitTreadin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedTest {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			int task = i;
			executorService.execute(() -> {

				System.out.println(Thread.currentThread().getName() + " " + task + "Started");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + " " + task + "Finished");
			});

		}
		executorService.shutdown();

	}
}
