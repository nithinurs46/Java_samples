import java.util.concurrent.Executor;

class Task implements Runnable {
	public void run() {
		System.out.println("Calling Task.run() ");
	}
}

class RepeatedExecutor implements Executor {
	public void execute(Runnable runnable) {
		new Thread(runnable).start();
	}

	public void execute(Runnable runnable, int times) {
		System.out.printf("Calling Task.run() %d times thro' Executor.execute() %n", times);
		for (int i = 0; i < times; i++) {
			execute(runnable);
		}
	}
}

// This class spawns a Task thread and explicitly calls start() method.
// It also shows how to execute a Thread using Executor
class ExecutorTest {
	public static void main(String[] args) {
		Runnable runnable = new Task();
		System.out.println("Calling Task.run() by directly creating a Thread");
		Thread thread = new Thread(runnable);
		thread.start();
		RepeatedExecutor executor = new RepeatedExecutor();
		executor.execute(runnable, 3);
	}
}