package com.gk.study.effectivejava;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

/**
 * Consider Static Factory Methods instead of Constructors
 * */


class Employee{
	private String name;
	
	private Employee(String n){
		this.name=n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static Employee getEmployee(String n){
		return new Employee(n);
	}

}

public class Item1 { 

	public static void main(String args[]){
		Employee emp1 = Employee.getEmployee("Gopi");
		Employee emp2 = Employee.getEmployee("Gopi"); 
		
		
		//Assert.assertNotSame(emp1, emp2);
		
		for(int i=1;i<30;i++){
			//System.out.println(i+": isPrime? ->"+BigInteger.pr);
		}
		
		List<String> l = Collections.emptyList();
		
		//l = new ArrayList<>();
		l.add("Test1");
		
		//Assert.assertEquals(1, l.size());
		
	}
	
}
