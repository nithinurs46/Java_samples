package operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamEx {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		IntStream.range(1, 10).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Time taken by stream  : " + (end - start));

		System.out.println("***********************************************");

		start = System.currentTimeMillis();
		IntStream.range(1, 10).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Time taken by  parallel stream : " + (end - start));

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		List<Employee> employees = getEmployees();

		// normal
		start = System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average()
				.getAsDouble();
		end = System.currentTimeMillis();

		System.out.println("Normal stream execution time : " + (end - start) + " : Avg salary : " + salaryWithStream);

		start = System.currentTimeMillis();
		double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i)
				.average().getAsDouble();

		end = System.currentTimeMillis();

		System.out.println(
				"Parallel stream execution time : " + (end - start) + " : Avg salary : " + salaryWithParallelStream);
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
