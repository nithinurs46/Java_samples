import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import models.Person;

public class Java8Sorting {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("AAA", "BBB", 12), new Person("BBBB", "Cdshfds", 21),
				new Person("sdfhkj", "dauhdifh", 10), new Person("erwer", "ewrwer", 22), new Person("vvdd", "dddd", 54),
				new Person("drii", "iohhh", 54));

		// sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// prints the collection sorted by last name --
		System.out.println("Collection sorted by last name:--");
		printConditionally(people, p -> true, p->System.out.println(p));

		// print all the last name beginning with d --
		System.out.println("print all the last name beginning with d --: ");
		printConditionally(people, p -> p.getLastName().startsWith("d"), p->System.out.println(p));

		// print all the first name beginning with d --
		System.out.println("print all the first name beginning with d --: ");
		printConditionally(people, p->p.getFirstName().startsWith("d"), p->System.out.println(p));
		
		System.out.println("print all the persons using for each feature --: ");
		people.forEach(p->System.out.println());
		
		//using streams
		System.out.println("**Streams**");
		people.stream().filter(p->p.getFirstName().startsWith("A")).forEach(p->System.out.println(p));
		
		
		System.out.println("** count**");
		long count = people.stream().filter(p->p.getFirstName().startsWith("A")).count();
		System.out.println(count);
	}

	/*private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println("Persons:--" + p);
		}
	}*/
	
	//using predicates instead of writing an interface,
	//making use of interfaces in java.util.Function
	/*private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p))
				System.out.println("Persons:--" + p);
		}
	}*/
	
	private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p))
				consumer.accept(p);
		}
	}

	
}
