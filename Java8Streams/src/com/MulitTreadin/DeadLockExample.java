package com.MulitTreadin;


class Resource1{
	void resource(Resource2 resource2) {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}
class Resource2{
	void resource(Resource1 resource1) {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}


public class DeadLockExample {
	
	
	
	public static void main(String[] args) {

	}
}
