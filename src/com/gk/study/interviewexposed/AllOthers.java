package com.gk.study.interviewexposed;

import java.io.Serializable;
import java.util.Date;

import org.junit.Assert;




public class AllOthers {
	
	public static void main(String args[]){
		
		
	Date now = new Date();
		System.out.println(now);
		
		java.sql.Date d1 = new java.sql.Date(now.getTime());
		//d1.setMonth(-2);
		java.sql.Date d2 = new java.sql.Date(now.getTime());
		//d2.setMonth(3);
		
		java.sql.Date currentDate = new java.sql.Date(now.getTime());
		
		System.out.println(d1+","+d2+","+currentDate);
		System.out.println(currentDate.compareTo(d1));
		System.out.println(currentDate.compareTo(d2));
		
		System.out.println(currentDate.compareTo(d1) * currentDate.compareTo(d2));
		
		System.out.println(currentDate.after(d1) && currentDate.before(d2));
		
		AllOthers a = new AllOthers();
		a.printClass();
		
	}
	
	private void printClass(){
		System.out.println(this.getClass());
	}

}
