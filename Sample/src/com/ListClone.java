package com;

import java.util.ArrayList;

public class ListClone {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(8);
		a.add(6);
		a.add(3);

		ArrayList b = new ArrayList();
		b = (ArrayList) a.clone();

		b.add(2); //adding number 2
		b.remove(2);  //removes value from index position 2.
		//b.remove(Integer.valueOf(2)); // use this to remove the number 2
		System.out.println(b.equals(a));
	}

}
