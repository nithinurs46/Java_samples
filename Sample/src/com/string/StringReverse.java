package com.string;

public class StringReverse {

	public static String reverseString1(String data) {
		String reverse = "";
		char[] c = data.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			reverse += c[i];
		}
		System.out.println("reverseString1:=" + reverse);
		return reverse;
	}

	public static void main(String[] args) {
		String data = "ABD";
		StringReverse.reverseString1(data);
	}
}
