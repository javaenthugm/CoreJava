package com.gk.study.interviewexposed;

public class RecursionTest {

	
	public static void recur(int y){
		if(y>0){
			System.out.println(y);
			recur(y-1);
			System.out.println(y);
		}
	}
	
	public static void main(String args[]){
		recur(10000);
	}
	
}
