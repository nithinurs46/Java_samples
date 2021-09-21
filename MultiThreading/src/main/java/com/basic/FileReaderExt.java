package com.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Utility;

public class FileReaderExt extends Thread {
	Utility obj = new Utility();

	@Override
	public void run() {
		try (BufferedReader reader = new BufferedReader(new FileReader(obj.getFile("sample.txt")))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileReaderExt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FileReaderExt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (URISyntaxException ex) {
			Logger.getLogger(FileReaderExt.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String[] args) {
		FileReaderExt app1 = new FileReaderExt();
		FileReaderExt app2 = new FileReaderExt();
		FileReaderExt app3 = new FileReaderExt();

		app1.setPriority(3);
		app2.setPriority(2);
		app3.setPriority(1);

		app1.start();
		app2.start();
		app3.start();

		System.out.println("Priority 1:- " + app1.getPriority());
		System.out.println("Priority 2:- " + app2.getPriority());
		System.out.println("Priority 3:- " + app2.getPriority());

	}

}
