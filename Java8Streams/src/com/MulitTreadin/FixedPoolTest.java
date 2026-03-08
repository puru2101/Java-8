package com.MulitTreadin;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolTest {

	static void printTable() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 2 * " + i + " = " + 2 * i);

		}
	}

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 5; i++) {
			int task = i;

			executor.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " started task " + task);

				try {
					Thread.sleep(2000); // simulate work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + " finished task " + task);
			});
		}

		executor.shutdown();

	}
}
