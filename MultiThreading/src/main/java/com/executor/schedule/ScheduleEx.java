package com.executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleEx {

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		// Start the scheduler after a inital delay of 3 seconds
		// executor.schedule(new DeleteFile(), 3, TimeUnit.SECONDS);

		// Start the scheduler after a inital delay of 3 seconds and then execute the
		// scheduler after every 5 seconds + initial delay
		// executor.scheduleAtFixedRate(new DeleteFile(), 3, 5, TimeUnit.SECONDS);
		
		// Start the scheduler after a inital delay of 3 seconds and then execute the
		// scheduler after every 5 seconds
		executor.scheduleWithFixedDelay(new DeleteFile(), 3, 5, TimeUnit.SECONDS);

	}

}
