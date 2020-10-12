package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BuiltInFunInt {

	public static void main(String[] args) {
		
		System.out.println("predicate test");
		//predicates
		Stream.of("hello", "world").filter(str -> str.startsWith("h")).forEach(System.out::println);
		
		Predicate<String> isNull = arg->arg!=null;
		Predicate<String> isEmpty = arg->arg.length()>0;
		Predicate<String> isEmptyAndNull = isNull.and(isEmpty);
		String someString = "aaa";
		String emptyString = "";
		String nullString = null;
		
		System.out.println(isEmptyAndNull.test(someString));
		System.out.println(isEmptyAndNull.test(emptyString));
		System.out.println(isEmptyAndNull.test(nullString));
		
		List<String> greeting = new ArrayList<>();
		greeting.add("hello");
		greeting.add("world");
		greeting.removeIf(str -> !str.startsWith("h"));
		greeting.forEach(System.out::println);
		
		
		//consumer - A Consumer<T> “consumes” something: it takes an argument (of generic type T) and returns nothing
		//(void). You can call accept() method on a Consumer object.
		
		System.out.println("consumer test");
		Stream.of("hello", "world").forEach(System.out::println);
		
		Consumer<String> upperCase = str->System.out.println(str.toUpperCase());
		upperCase.accept("abdc");
		
		//function -- takes na argument and returns result
		System.out.println("function test");
		Arrays.stream("4, -9, 16".split(", "))
		.map(Integer::parseInt)
		.map(i -> (i < 0) ? -i : i)
		.forEach(System.out::println);
		
		Function<String, Integer> strLength = str -> str.length();
		System.out.println(strLength.apply("supercalifragilisticexpialidocious"));
		
		Function<String, Integer> parseInt = Integer::parseInt;
		Function<Integer, Integer> absInt = Math::abs;
		Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);
		Arrays.stream("4, -9, 16".split(", "))
		.map(parseAndAbsInt)
		.forEach(System.out::println);
		
		//supplier --method that does not take any input but returns some output.
		
		System.out.println("Supplier test");
		Random random = new Random();
		Stream.generate(random::nextInt)
		.limit(2)
		.forEach(System.out::println);
		
		Supplier<String> currentDateTime = () -> LocalDateTime.now().toString();
		System.out.println(currentDateTime.get());
	}

}
