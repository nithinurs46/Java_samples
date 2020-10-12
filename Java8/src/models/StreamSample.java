package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample {

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<Integer>();
		data.add(2);
		data.add(3);
		data.add(4);
		//returns true if any element matches predicate
		boolean anyMatch = data.stream().anyMatch(n -> n > 2);
		System.out.println("Any Match: "+anyMatch);
		
		//returns true of all the element matches predicate, if stream is empty, return true
		boolean allMatch = IntStream.of(2,5,6).allMatch(n -> n<3);
		System.out.println("All Match: "+allMatch);
		
		//Returns true only if none of the elements in the stream matches the
		//given predicate. Returns true if the stream is empty
		boolean noneMatch = Stream.of("Hi", "aaa").noneMatch(s -> s.startsWith("H"));
		System.out.println("None Match"+noneMatch);
		
		Optional<String> findFirst = Stream.of("html", "spring boot","spring")
				.filter(s->s.contains("boot"))
				.findFirst();
		System.out.println("findfirst: "+findFirst);
		
		Optional<String> findAny = Stream.of("html", "spring boot","spring")
				.filter(s->s.contains("spring"))
				.findAny();
		System.out.println("findAny: "+findAny);
		
		Optional<String> string = Optional.of(" abracadabra ");
		string.map(String::trim).ifPresent(System.out::println);
		
		Optional<String> string1 = Optional.ofNullable(null);
		string1.map(String::length).orElse(-1);
		System.out.println(string1.map(String::length).orElse(-1));
		
		//Optional<String> string2= Optional.ofNullable(null);
		//System.out.println(string2.map(String::length).orElseThrow(IllegalArgumentException::new));
		
		List<String> words = Arrays.asList("follow your heart but take your brain with you".split(" "));
				words.stream().distinct().sorted().forEach(System.out::println);
				
				Comparator<String> lengthCompare = (str1, str2) -> str1.length() - str2.length();
				words.stream().distinct().sorted(lengthCompare).forEach(System.out::println);
				
				//natural ordering if length are same
				
				words.stream()
				.distinct()
				.sorted(lengthCompare.thenComparing(String::compareTo))
				.forEach(System.out::println);
				
				//reversed
				words.stream()
				.distinct()
				.sorted(lengthCompare.thenComparing(String::compareTo).reversed())
				.forEach(System.out::println);
				
				List<String> sortedList = words.stream()
				.distinct()
				.sorted(lengthCompare.thenComparing(String::compareTo).reversed())
				.collect(Collectors.toList());
				sortedList.forEach(System.out::println);
				
				Set<String> sortedSet = words.stream()
				.sorted(lengthCompare.thenComparing(String::compareTo).reversed())
				.collect(Collectors.toSet());
				System.out.println(sortedSet);
				
				Map<String, Integer> nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
				.collect(Collectors.toMap(name -> name, name -> name.length()));
				nameLength.forEach((name, len) -> System.out.printf("%s - %d \n", name, len));
			
				
				//map
				
				List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
				integers.stream()
				.map(i -> i * i)
				.forEach(System.out::println);
				
				//flatmap flattens the streams that result from mapping each of its elements into one flat stream.
				System.out.println("flatMap");
				List<List<Integer>> intsOfInts = Arrays.asList(
						Arrays.asList(1, 3, 5),
						Arrays.asList(2, 4));
						intsOfInts.stream()
						.flatMap(ints -> ints.stream())
						.sorted()
						.map(i -> i * i)
						.forEach(System.out::println);
				
	}
}
