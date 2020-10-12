package com;

class InterfaceImpl implements InterfaceTest {

	@Override
	public void anotherMethod() {
		System.out.println("anotherMethod");

	}

	public static void main(String[] args) {
		InterfaceTest test = new InterfaceImpl();
		test.anotherMethod();
		InterfaceTest.someMethod();

	}

}
