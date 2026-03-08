package com.MulitTreadin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTPTest {

	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

		executorService.schedule(() -> {
			System.out.println(Thread.currentThread().getName() + " Task executed after 1 minute");
		}, 1, TimeUnit.MINUTES);
	}

}
