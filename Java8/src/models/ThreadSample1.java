package models;

public class ThreadSample1 extends Thread{
	
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("In run(); thread name is: " + getName());
	}
	
	public static void main(String[] args) {
		ThreadSample1 th = new ThreadSample1();
		th.start();
		System.out.println("In main(); thread name is: " +
				Thread.currentThread().getName());
	}

}

class ThreadSample2 implements Runnable {

	@Override
	public void run() {
		System.out.println("In run(); thread name is: " +
				Thread.currentThread().getName());
		
	}
	
	public static void main(String[] args) {
		Thread myThread = new Thread(new ThreadSample2());
		myThread.start();
		System.out.println("In main(); thread name is: " +
				Thread.currentThread().getName());
	}
}
