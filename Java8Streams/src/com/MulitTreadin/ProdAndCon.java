package com.MulitTreadin;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {

	int id;
	String Name;

}

public class ProdAndCon {

	Queue<Integer> q = new LinkedList<>();
	int capacity = 5;

	public void producer(Integer e) throws InterruptedException {
		while (q.size() == capacity) {
			System.out.println("Queue is full");
			wait();
		}

		q.add(e);
		System.out.println("Record produce" + e);
		notifyAll();
	}

	public void consumer() throws InterruptedException {
		while (q.isEmpty()) {
			System.out.println("Waitin for record");
			wait();
		}

		Integer e1 = q.poll();
		System.out.println("Record produce" + e1);
		notifyAll();
	}

	public static void main(String[] args) {
		ProdAndCon pc = new ProdAndCon();
		Thread producer = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					pc.producer(i);
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		Thread consumer = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					pc.consumer();
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		producer.start();
		consumer.start();

	}

}
