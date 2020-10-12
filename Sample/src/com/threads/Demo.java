package com.threads;

 class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	}

}

public class Demo {
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			Thread1 th = new Thread1();
			th.start();
		}
		
	}
}
