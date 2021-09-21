package com.executor.threadfactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCustomThreadFactory implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("Thread Name:- " + Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2, new CustomThreadFactory());

		for (int i = 0; i < 5; i++) {
			executor.submit(new TestCustomThreadFactory());
		}

	}

}
