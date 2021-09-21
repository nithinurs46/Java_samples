package com.executor.synchronousOp;

public class Producer implements Runnable {
	private Message msg;

	public Producer(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				msg.setMsg(name + " message created");
				msg.notify();
				//msg.notifyAll();
				System.out.println(name + " Exit synchronized block");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
