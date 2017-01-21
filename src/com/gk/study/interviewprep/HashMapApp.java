package com.gk.study.interviewprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Test {
	final int i;

	public Test() {
		i = 10;
		setup();
	}

	public void setup() {
		// setup code
	}
}

class Key {
	int index;
	String name;

	public Key(int i, String s) {
		this.index = i;
		this.name = s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
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
		Key other = (Key) obj;
		if (index != other.index)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * public int hashCode() { return 5; }
	 * 
	 * public boolean equals(Object obj) { return true; }
	 */

}

public class HashMapApp {
	
	 final class MyInner{
		   public MyInner() {
			   System.out.println("My Inner");
		}
	   }

	public static void main(String args[]) {

		HashMap<Key, String> map = new HashMap<>();
		map.put(new Key(1, "NY"), "New York");
		map.put(new Key(2, "NJ"), "New Jersy");
		map.put(new Key(3, "NP"), "New Port");
		map.put(new Key(4, "MD"), "Maryland");

		System.out.println("Size before Iteration : " + map.size());
		Iterator<Key> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println(map.get(iter.next()));
		}
		System.out.println("Size After Iteration : " + map.size());
		
		Test t = new Test();
		System.out.println(t.i);
		
		final int i;
		   int a=2,b=3;
		   double x;
		   x = a+b;
		   System.out.println("Result = "+x);
		   
		  

		   
	}

}
