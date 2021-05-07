package operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMapEx {

	public static void main(String[] args) {
		List<Employee> employees = getEmployees();
		List<Double> salary = employees.stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
		System.out.println(salary);
		
		//One employee is having multiple phone numbers, hence list of list is used here
		//One to Many mapping
		//Output will have stream of phone numbers
		//[[397937955, 21654725], [345345345, 64546456], [576745645, 23243566], [34536356, 13235366], [225211433, 1534564565]]
		List<List<String>> phoneNos = employees.stream().map(e -> e.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println(phoneNos);
		
		
		//One to many mapping
		//Output will have list of phone numbers in flatmap
		//[397937955, 21654725, 345345345, 64546456, 576745645, 23243566, 34536356, 13235366, 225211433, 1534564565]
		List<String> phoneNosList = employees.stream().flatMap(e -> e.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phoneNosList);

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
