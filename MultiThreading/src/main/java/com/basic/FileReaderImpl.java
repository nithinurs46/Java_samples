package com.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Utility;

public class FileReaderImpl {

	public static void main(String[] args) {
		Utility obj = new Utility();
		Runnable runnable = () -> {

			try (BufferedReader reader = new BufferedReader(new FileReader(obj.getFile("sample.txt")))) {
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
		Thread t1 = new Thread(runnable); // New
		t1.start(); // Runnable

		Thread t2 = new Thread(runnable);
		t2.start();

		Thread t3 = new Thread(runnable);
		t3.start();
	}

}
