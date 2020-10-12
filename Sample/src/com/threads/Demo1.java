package com.threads;

class Thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	}

}

public class Demo1 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread th2 = new Thread(new Thread2());
			th2.run();
		}
	}

}
