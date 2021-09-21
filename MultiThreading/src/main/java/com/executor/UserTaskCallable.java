package com.executor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.Utility;

public class UserTaskCallable implements Callable<User> {

	private String userRecord;

	public UserTaskCallable(String userRecord) {
		this.userRecord = userRecord;
	}

	@Override
	public User call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " processing record for : " + userRecord);
		String[] record = userRecord.split(",");
		return User.builder().userId(Integer.parseInt(record[2])).userName(record[1]).emailId(record[0]).build();
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<String> users = readUserDataFromFile("new_users.txt");
		for (String user : users) {
			// future.get is a blocking operation. Main method is going to be blocked until it gets the future value
			//comment try-catch block and verify, Exit main method gets called in-between if not blocked.
			Future<User> futureObj = executor.submit(new UserTaskCallable(user));
			try {
				System.out.println("User is:- " + futureObj.get());
			} catch (InterruptedException | ExecutionException e) {
				Logger.getLogger(UserTaskCallable.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		executor.shutdown();
		System.out.println("Exit Main Method");
	}

	public static List<String> readUserDataFromFile(String fileName) {
		Utility obj = new Utility();
		List<String> users = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(obj.getFile(fileName)))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				users.add(line);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(UserTaskCallable.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(UserTaskCallable.class.getName()).log(Level.SEVERE, null, ex);
		} catch (URISyntaxException ex) {
			Logger.getLogger(UserTaskCallable.class.getName()).log(Level.SEVERE, null, ex);
		}
		return users;
	}
}
