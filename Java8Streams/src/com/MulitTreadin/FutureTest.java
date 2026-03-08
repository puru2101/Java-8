package com.MulitTreadin;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService excecutorService = Executors.newSingleThreadExecutor();
		Callable<String> callable = () -> {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(150);
			return "Working...";
		};

		Future<String> future = excecutorService.submit(callable);
		System.out.println("Main thread doing other work...");

		System.out.println(future.isDone());
		String str = future.get();
		System.out.println(str);
		System.out.println(future.isDone());

		System.out.println("Work is completed");

		excecutorService.shutdown();
	}

}
