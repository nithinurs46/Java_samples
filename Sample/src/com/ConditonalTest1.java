package com;

public class ConditonalTest1 {

	public static void main(String[] args) {
		ConditonalTest1 test = new ConditonalTest1();
		System.out.println("Day:- " + test.getNumber("Tuesday"));
	}

	public int getNumber(String day) {
		int no = 0;
		if (day.equals("Monday")) {
			no = 0;
		} else if (day.equals("Tuesday")) {
			no = 1;
		} else if (day.equals("Wednesday")) {
			no = 2;
		}

		return no;
	}
}
