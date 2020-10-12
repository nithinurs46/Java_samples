import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Person;

public class Java7Sorting {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("AAA", "BBB", 12), new Person("BBBB", "Cdshfds", 21),
				new Person("sdfhkj", "dauhdifh", 10), new Person("erwer", "ewrwer", 22), new Person("vvdd", "dddd", 54),
				new Person("drii", "iohhh", 54));

		// sort list by last name
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());

			}
		});

		// prints the collection sorted by last name --
		System.out.println("Collection sorted by last name:--");
		printAll(people);

		// print all the last name beginning with d --
		System.out.println("print all the last name beginning with d --: ");
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("d");
			}
		});

		// print all the first name beginning with d --
		System.out.println("print all the first name beginning with d --: ");
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("d");
			}
		});

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println("Persons:--" + p);
		}
	}

	private static void printAll(List<Person> people) {
		for (Person p : people) {
			System.out.println("Persons:--" + p);
		}
	}

}
