package com;

public class Singleton {

	private Singleton() {

	}

	private static Singleton obj = null;

	public static Singleton getInstance() {
		if (obj == null) {
			obj = new Singleton();
		}
		return obj;

	}
	
	public static void main(String[] args) {
		Singleton test = Singleton.getInstance();
		System.out.println(test);
	}
}
