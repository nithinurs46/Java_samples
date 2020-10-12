package com;

public class IncrementTest {

	public static void main(String[] args) {
		int i=1;
		System.out.println(i);
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		
		int c = 3;
		int a = c++; 
		System.out.println("C: "+c);
		System.out.println(a);
		int b = ++a;
		System.out.println(b);
	}
}
