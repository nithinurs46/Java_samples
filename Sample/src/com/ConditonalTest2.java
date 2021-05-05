package com;

public class ConditonalTest2 {

	public enum Weekday {
		Monday(0), Tuesday(1), Wednesday(2);

		private int number;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		Weekday(int i) {
			this.setNumber(i);
		}
	}
	
	public static void main(String[] args) {
		Weekday day = Weekday.valueOf("Tuesday");
		System.out.println("Number enum:"+ day.getNumber());
	}
}
