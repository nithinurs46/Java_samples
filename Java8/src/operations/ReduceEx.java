package operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceEx {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 4, 17, 9, 6, 3);

		int sum = numbers.stream().mapToInt(i -> i).sum();
		System.out.println("Sum : " + sum);

		Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("reduceSum : " + reduceSum);

		Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
		System.out.println(reduceSumWithMethodReference.get());

		Integer multiply = numbers.stream().reduce(0, (a, b) -> a * b);
		System.out.println("multiply: " + multiply);

		Integer max = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println("max number: " + max);

		Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxvalueWithMethodReference);

		Integer minValWithMethodRef = numbers.stream().reduce(Integer::min).get();
		System.out.println(minValWithMethodRef);

		List<String> words = Arrays.asList("India", "Australia", "New Zealand");

		String longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
				.get();
		System.out.println(longestString);

		double avgSalary = getEmployees().stream().filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
				.map(employee -> employee.getSalary()).mapToDouble(i -> i).average().getAsDouble();

		System.out.println("Avg Salary of Grade A Employees: " + avgSalary);

		double sumSalary = getEmployees().stream().filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
				.map(employee -> employee.getSalary()).mapToDouble(i -> i).sum();
		System.out.println("Sum of Salary of Grade A Employees: " + sumSalary);
	}

	public static List<Employee> getEmployees() {
		return Stream
				.of(new Employee(101, "Sachin", "A", 60000, Arrays.asList("397937955", "21654725")),
						new Employee(102, "Rahul", "B", 30000, Arrays.asList("345345345", "64546456")),
						new Employee(103, "Virat", "A", 80000, Arrays.asList("576745645", "23243566")),
						new Employee(104, "Raj", "A", 90000, Arrays.asList("34536356", "13235366")),
						new Employee(105, "Ram", "C", 15000, Arrays.asList("225211433", "1534564565")))
				.collect(Collectors.toList());
	}
}
