package com.executor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Utility;
import com.basic.FileReaderExt;

public class FileReadExecutor {

	public static void main(String[] args) {
		Utility obj = new Utility();
		Runnable runnable = () -> {
			try (BufferedReader reader = new BufferedReader(
					new FileReader(obj.getFile("sample.txt")))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
				}
			} catch (FileNotFoundException ex) {
				Logger.getLogger(FileReaderExt.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(FileReaderExt.class.getName()).log(Level.SEVERE, null, ex);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		};

		Executor executor = Executors.newFixedThreadPool(4);
		executor.execute(runnable);
	}

}
