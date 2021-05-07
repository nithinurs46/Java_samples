package operations;

import java.util.List;

public class Employee {
	private int id;
	private String name;
	private String grade;
	private double salary;
	private List<String> phoneNumbers;

	public Employee() {
	}

	public Employee(int id, String name, String grade, double salary, List<String> phoneNumbers) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.salary = salary;
		this.phoneNumbers = phoneNumbers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
