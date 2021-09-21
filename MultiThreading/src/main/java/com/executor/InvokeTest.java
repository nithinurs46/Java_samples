package com.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvokeTest implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		Logger.getLogger(InvokeTest.class.getName()).log(Level.INFO,
				"Invoking call method" + Thread.currentThread().getName());
		return true;
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables = new ArrayList<>();
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());
		callables.add(new InvokeTest());

		try {
			List<Future<Boolean>> future = executor.invokeAll(callables);
			future.forEach(f -> {
				try {
					Logger.getLogger(InvokeTest.class.getName()).log(Level.INFO, "InvokeAll Future Get:- " + f.get());
				} catch (InterruptedException | ExecutionException e) {
					Logger.getLogger(InvokeTest.class.getName()).log(Level.SEVERE, null, e);
				}
			});
		} catch (InterruptedException e) {
			Logger.getLogger(InvokeTest.class.getName()).log(Level.SEVERE, null, e);
		}

		System.out.println("**********************************************************");

		try {
			Boolean future = executor.invokeAny(callables);
			Logger.getLogger(InvokeTest.class.getName()).log(Level.INFO, "InvokeAny Future Get:- " + future);
		} catch (InterruptedException | ExecutionException e) {
			Logger.getLogger(InvokeTest.class.getName()).log(Level.SEVERE, null, e);
		}
		executor.shutdown();
	}
}
