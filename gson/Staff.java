package gson;

import java.time.LocalDateTime;


public class Staff {

	private String name;
	private int age;
	private LocalDateTime birthDate;

	public String getStaffName() {
		return name;
	}

	public void setStaffName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", birthDate=" + birthDate + "]";
	}
}
