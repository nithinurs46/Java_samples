package com.copy;

public class TestCopy {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employee e1 = new Employee();
		e1.setEmpId("45");
		e1.setEmpName("A");
		Department d1 = new Department();
		e1.setDept(d1);
		e1.getDept().setDeptId("dept id 1");
		e1.getDept().setDeptName("dept name 1");
		System.out.println("before copy: "+e1);
		
		Employee e2 = e1;
		e2.empId = "46";
		e2.getDept().setDeptName("dept name new");
		System.out.println("After copy: "+e1); //[empName=A, empId=46]
		System.out.println("After copy: "+e1.getDept()); //[deptName=dept name new, deptId=dept id 1]
		
		Employee e3 = (Employee) e1.clone();
		e3.empId = "47";
		e3.getDept().setDeptName("dept name new 3");
		System.out.println("After copy: "+e1); //[empName=A, empId=46]
		System.out.println("After copy: "+e1.getDept()); //[deptName=dept name new 3, deptId=dept id 1]
		
		
	}

}
