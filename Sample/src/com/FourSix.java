package com;

public class FourSix {
	
	static String s = "Instance";
	
	public static void method(String s) {
		s+="Add";
	}

	public static void main(String[] args) {
		FourSix obj = new FourSix();
		s = "New Instance";
		String s = "local";
		method(s);
		System.out.println(s);
		System.out.println(obj.s);
	}
	
	
}
