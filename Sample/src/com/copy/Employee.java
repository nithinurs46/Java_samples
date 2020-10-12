package com.copy;

public class Employee implements Cloneable {
	
	String empName;
	String empId;
	
	Department dept;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//return super.clone(); shallow cloning
	
		//deep cloning ->
		 Employee emp = (Employee)super.clone();
		 emp.setDept((Department)emp.getDept().clone());   
		 return emp;
		
	}
}
