package com.executor.schedule;

import java.io.File;

public class DeleteFile implements Runnable {

	@Override
	public void run() {
		System.out.println("Calling run method "+ java.time.LocalDateTime.now());  
		File folder = new File("C:\\temp\\Logs");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				// greater then 5 mins -- converted to millis
				if (System.currentTimeMillis() - file.lastModified() < 5 * 60 * 1000) {
					boolean status = file.delete();
					System.out.println(file.getName() + " deletion status:- " + status);
				}
			}
		}
	}

}
