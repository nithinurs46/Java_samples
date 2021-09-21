package com.executor.synchronousOp;

public class Consumer implements Runnable {

	private Message msg;

	public Consumer(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting to get notified at time: " + System.currentTimeMillis());
				msg.wait();
				System.out.println(name + " Exit synchronized block");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " thread got notified at time: " + System.currentTimeMillis());
			// process the message now
			System.out.println(name + " processed: " + msg.getMsg());
		}
	}

}
