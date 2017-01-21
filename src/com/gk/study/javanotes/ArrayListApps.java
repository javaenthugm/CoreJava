package com.gk.study.javanotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

class Dog implements Comparable<Dog>,Comparator<Dog>{
	private int age;
	private String name;
	
	public Dog(){
		
	}
	
	public Dog(int pAge, String pName){
		this.age = pAge;
		this.name = pName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Dog o) {
		return this.name.compareTo(o.name);
	}
	
	
	public int compare(Dog d, Dog o){
		return d.age - o.age;
	}
	
}

public class ArrayListApps {
	
	public static void main(String args[]){
		List<Dog> list = new ArrayList<>();
		list.add(new Dog(3,"Shady"));
		list.add(new Dog(2,"Kane"));
		list.add(new Dog(6,"Gray"));
		list.add(new Dog(10,"Snoop"));
		
		Collections.sort(list);
		
		for(Dog d : list)
			System.out.println(d.getName()+"-"+d.getAge()+",");
		
		Collections.sort(list, new Dog());
		
		for(Dog d : list)
			System.out.println(d.getName()+"-"+d.getAge()+",");
		
		
	}

}
