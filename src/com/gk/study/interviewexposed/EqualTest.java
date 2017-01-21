package com.gk.study.interviewexposed;

import java.util.Date;

class EmployeeEq{
	private String name;
	public EmployeeEq(String n){
		name=n;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEq other = (EmployeeEq) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	
	
	
	
}

public class EqualTest {
	public static void main(String args[]){
		
		addShutdwonHook();
		
		EmployeeEq e1 = new EmployeeEq("Gopi");
		EmployeeEq e2 = new EmployeeEq("Gopi");
		
		System.out.println(e1.equals(e2));
		System.out.println(e1 == e2);
		
		
	  
	}
	
	public static void addShutdwonHook(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				System.err.println("Shutting down JVM at time:"+new Date());
			}
		});
	}
}
