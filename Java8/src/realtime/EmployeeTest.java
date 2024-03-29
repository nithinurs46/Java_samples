package realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeTest {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out
				.println("No of male and female employees in the organization:- " + noOfMaleAndFemaleEmployees + "\n");

		// Print the name of all departments in the organization?
		List<String> deptNames = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println("name of all departments in the organization:- " + deptNames + "\n");

		// What is the average age of male and female employees?
		Map<String, Double> avgAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("average age of male and female employees:- " + avgAge + "\n");

		// Get the details of highest paid employee in the organization?
		Optional<Employee> highestSalEmp = employeeList.stream()
				// .max(Comparator.comparingDouble(Employee::getSalary));
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("highest paid employee in the organization :-> " + highestSalEmp.get() + "\n");

		// Get the names of all employees who have joined after 2015?
		List<String> after2015 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Employees who have joined after 2015 :-> " + after2015 + "\n");

		// Count the number of employees in each department?
		Map<String, Long> countDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Count in each dept:-> " + countDept + "\n");

		// What is the average salary of each department?
		Map<String, Double> avgSalaryInDept = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("average salary of each department:-> " + avgSalaryInDept + "\n");

		// Get the details of youngest male employee in the product development
		// department?
		Optional<Employee> youngestMaleEmployeeInPrdDev = employeeList.stream()
				.filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println("youngest male employee in the product development department:-> "
				+ youngestMaleEmployeeInPrdDev.get() + "\n");

		// Who has the most working experience in the organization?
		Optional<Employee> mostExpdEmp = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		System.out.println("most working experience in the organization:-> " + mostExpdEmp.get() + "\n");

		// How many male and female employees are there in the sales and marketing team
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("male and female employees count in sales and marketing team:-> "
				+ countMaleFemaleEmployeesInSalesMarketing + "\n");

		// What is the average salary of male and female employees?
		Map<String, Double> avgSalaryOfMaleAndFemaleEmp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("average salary of male and female employees:-> " + avgSalaryOfMaleAndFemaleEmp + "\n");

		// List down the names of all employees in each department
		Map<String, List<Employee>> empListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("names of all employees in each department:-> " + empListByDepartment + "\n");

		// What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics empSalaries = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Average Salary = " + empSalaries.getAverage());
		System.out.println("Total Salary = " + empSalaries.getSum() + "\n");

		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));

		Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<Employee>> entry : entrySet) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}
		System.out.println("---------------------------- \n ");

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?
		Optional<Employee> oldestEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("oldest Employee = " + oldestEmp.get() + "\n");
		
		//sum of squares of all odd numbers
		int[] numbers = { 3, 2, 5, 4 };
		int sum = Arrays.stream(numbers).filter(i -> i % 2 == 1).map(i -> i * i).reduce(0, (a, b) -> a + b);
		System.out.println("Sum of squares of all odd numbers:- " + sum);
		
		//longest even length word in a sentence.
		String sentence = "Be not afraid of greatness some are born great, some achieve greatness and some have greatness thrust upon them";
		String longestEvenWord = Arrays.stream(sentence.split(" ")).filter(s -> s.length() % 2 == 0)
				.max(Comparator.comparingInt(String::length)).orElse("");
		System.out.println("longest even length word in a sentence:-" + longestEvenWord);
		
	}
}
