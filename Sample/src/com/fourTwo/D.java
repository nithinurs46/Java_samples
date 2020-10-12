package com.fourTwo;

public class D extends B {

	public static void main(String[] args) {

		A a = new D();
		B b = new D();
		A c = new C();
		a.show();
		b.show();
		c.show();

		((C) c).check();
	}

}
