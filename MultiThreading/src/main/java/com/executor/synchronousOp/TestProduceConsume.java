package com.executor.synchronousOp;

public class TestProduceConsume {
	public static void main(String[] args) {
		Message msg = new Message("process it");
		
		Consumer consumer = new Consumer(msg);
		new Thread(consumer, "consumer").start();

		Consumer consumer1 = new Consumer(msg);
		new Thread(consumer1, "consumer1").start();

		Producer producer = new Producer(msg);
		new Thread(producer, "producer").start();
		System.out.println("All the threads are started");
		
		/*
		 * Output --
		 * notify->
		 * 
			consumer waiting to get notified at time: 1632211066887
			consumer1 waiting to get notified at time: 1632211066889
			All the threads are started
			producer started
			producer Exit synchronized block
			consumer Exit synchronized block
			consumer thread got notified at time: 1632211067892
			consumer processed: producer message created
			
			notifyAll->
			consumer waiting to get notified at time: 1632211035043
			consumer1 waiting to get notified at time: 1632211035043
			All the threads are started
			producer started
			producer Exit synchronized block
			consumer1 Exit synchronized block
			consumer1 thread got notified at time: 1632211036051
			consumer1 processed: producer message created
			consumer Exit synchronized block
			consumer thread got notified at time: 1632211036051
			consumer processed: producer message created
		 */
	}
}
