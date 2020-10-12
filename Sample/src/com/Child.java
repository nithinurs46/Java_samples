package com;

public class Child extends Parent {

	void draw() throws ArithmeticException {
		System.out.println("child");
	}
	public static void main(String[] args) {
		Parent p = new Child();
		try {
			p.draw();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

