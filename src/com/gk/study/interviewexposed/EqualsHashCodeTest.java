package com.gk.study.interviewexposed;

import java.util.HashSet;
import java.util.Set;


class Department{
	long deptId;
	String deptName;
	
	Set<Employee> empList;
	
	
	@Override
	public int hashCode() {
		System.out.println("Department HashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (deptId ^ (deptId >>> 32));
		result = prime * result
				+ ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((empList == null) ? 0 : empList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Department Equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptId != other.deptId)
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (empList == null) {
			if (other.empList != null)
				return false;
		} else if (!empList.equals(other.empList))
			return false;
		return true;
	}
	
	
	
}


class Employee{
	String empId;
	String empName;
	
	@Override
	public int hashCode() {
		System.out.println("Employee HashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Employee Equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}
	
	
	
}




public class EqualsHashCodeTest {
	
	
	public static void main(String args[]){
		
		Department d1 = new Department();
		d1.deptId=1;
		d1.deptName="dept-1";
		
		Employee e11 = new Employee();
		e11.empId=String.valueOf(11);
		e11.empName="emp11";
		
		Set<Employee> empList1 = new HashSet<Employee>();
		empList1.add(e11);
		
		d1.empList = empList1;
		
		Department d2 = new Department();
		d2.deptId=1;
		d2.deptName="dept-1";
		
		Employee e12 = new Employee();
		e12.empId=String.valueOf(11);
		e12.empName="emp11";
		/*
		Employee e13 = new Employee();
		e13.empId=String.valueOf(11);
		e13.empName="emp13";*/
		
		Set<Employee> empList2 = new HashSet<Employee>();
		empList2.add(e12);
		//empList2.add(e13);
		
		d2.empList = empList2;
		
		if(d1.equals(d2)){
			System.out.println("Equal");
		}else{
			System.out.println("Not Equal");
		}
		
		
		
	}

}
