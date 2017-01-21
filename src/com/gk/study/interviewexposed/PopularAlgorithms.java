package com.gk.study.interviewexposed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.IIOException;

import org.hsqldb.lib.StringUtil;
import org.junit.Assert;
import org.junit.Test;


class StaticTestClass{
	public static void staticMethod(){
		System.out.println("Employee Static Method");
	}
}

public class PopularAlgorithms {

	public static void main(String args[]){
		//// Regular FizzBuzz
		//System.out.println("Regular FizzBuzz->\t"+regularFizzBuzz(15));
		
		//// Alternate FizzBuzz
		//System.out.println("Alternate FizzBuzz->\t"+alternateFizzBuzz(15));
		
		//onDec FizzBuzz
		onDecFizzBuzz(50);
		
		//// Static Test 
		//StaticTestClass.staticMethod();
		
		//Fibonacci
		/*System.out.println("Fibonacci->\t\t"+fibonacci(8));

		System.out.println("nth Fibonacci->\t\t"+fibN(8));
		System.out.println("Cached Fibonacci->\t"+fibN(8));
		
		System.out.println("Cache Fibanocci tests for 45:");
		PopularAlgorithms pA = new PopularAlgorithms();
		pA.largeFib();*/
		
		//// Factorial
		//System.out.println("Factorial without Recurssion:\t"+factorialWithoutRecursion(6));
		//System.out.println("Factorial with Recurssion:\t"+factorialWithRecursion(5));
		
		//// Reverse String
		//System.out.println(reverseString("testing--tst"));
	/*	System.out.println(reverseStringInPlace("testing"));
		
		LinkedList<String> ls = new LinkedList<>();
		ls.add("1");
		ls.add("2");
		ls.add("3");
		
		System.out.println(ls.get(2));*/
		
		
	}
	
	
	private static void onDecFizzBuzz(int n){
		
		for(int i=1;i<=n;i++){
			/*final String word = findFizzBuzz(3,i,"Fizz") +findFizzBuzz(5,i,"Buzz");
			if(word!=null){
				System.out.println(i+"->"+word);
			}*/
			
			System.out.println(i+":"+findFizzBuzz(4, i, "Fizz")+findFizzBuzz(8, i, "Buzz"));
			
		}
		
	}

	private static String findFizzBuzz(final int divisor, final int value, String word) {
		return (value % divisor) == 0 ? word:""; 
	}
	
	
	private static String reverseStringInPlace(String s){
		StringBuilder sb = new StringBuilder(s);
		
		for(int i = 0;i< s.length()/2;i++){
			final char temp = sb.charAt(i);
			char otherEnd = sb.charAt(s.length()-1-i);
			sb.setCharAt(i, otherEnd);
			sb.setCharAt(sb.length()-1-i, temp);
		}
		
		return sb.toString();
	}
	
	/*
	 * This method consumes a lot of memory as it has to hold 
	 * both String and StringBuilder
	 * 
	 * **/
	private static String reverseString(String s){
		Arrays.sort(s.toCharArray());
		StringBuilder sb = new StringBuilder(s.length());
		for(int i=s.length()-1;i>=0;i--){
			sb.append(s.charAt(i));
		}
		
		
		//return sb.toString();
		return sb.reverse().toString();
	}
	
	private static long factorialWithRecursion(int n){
		if(n<1){
			throw new IllegalArgumentException("n cannot be less than 1");
		}
		
		if(n==1){
			return 1;
		}
		
		return n*factorialWithRecursion(n-1);
	}
	
	private static long factorialWithoutRecursion(int n){
		if(n<1){
			throw new IllegalArgumentException("n cannot be less than 1");
		}
		long fact = 1;
		for(int i=1;i<=n;i++){
			fact*=i;
		}
		return fact;
	}
	
	@Test
	public void largeFib(){
		final long nonCachedStart = System.nanoTime();
		Assert.assertEquals(1134903170, fibN(45));
		final long nonCachedFinish = System.nanoTime();
		Assert.assertEquals(1134903170, cachedFibN(45));
		final long cachedFinish = System.nanoTime();
		
		System.out.printf("\tNon cahced time : %d nanosecond %n", nonCachedFinish - nonCachedStart );
		System.out.printf("\tNon cahced time : %d seconds %n", (nonCachedFinish - nonCachedStart)/1000000000 );
		System.out.printf("\tCahced time : %d nanosecond %n", cachedFinish - nonCachedFinish );
		System.out.printf("\tCahced time : %d seconds %n", (cachedFinish - nonCachedFinish)/1000000000 );
	}
	
	private static Map<Integer, Integer> fibCache = new HashMap<Integer, Integer>();
	private static int cachedFibN(int n){
		if(n<0){
			throw new IllegalArgumentException("n cannot be less than zero");
		}
		
		fibCache.put(0, 0);
		fibCache.put(1, 1);
		
		return recursiveCachedFibN(n);
	}
	
	private static int recursiveCachedFibN(int n) {
		if(fibCache.containsKey(n)){
			return fibCache.get(n);
		}
		
		int value = (recursiveCachedFibN(n-1) + recursiveCachedFibN(n-2));
		fibCache.put(n, value);
		return value;
	}

	/**
	 * This method is extremely inefficient 
	 * e.g fibN(45) is calculated from fibN(44) and finN(43)
	 * and fibN(44) is calculated from finN(43) and fibN(42)
	 * 		here fibN(43) is calculated twice.
	 * */
	private static int fibN(int n){
		
		if(n<0){
			throw new IllegalArgumentException("n cannot be less than zero");
		}
		
		if(n==1) return 1;
		if(n==0) return 0;
		return (fibN(n-1)+fibN(n-2));
	}
	
	
	
	/**
	 * Write a method that returns a Fibonacci sequence from 1 to n
	 * @param n
	 * @return List<Integer> 
	 */
	private static List<Integer> fibonacci(Integer n){
		if(n<0){
			throw new IllegalArgumentException("n must not be less than zero");
		}
		
		if(n==0){
			return Arrays.asList(0);
		}
		
		if(n==1){
			return Arrays.asList(0,1);
		}
		
		List<Integer> seq = new ArrayList<>(n);
		seq.add(0);
		n = n-1;
		seq.add(1);
		n = n-1;
		
		while(n>0){
			int a = seq.get(seq.size()-1);
			int b = seq.get(seq.size()-2);
			seq.add(a+b);
			n= n-1;
		}
		
		/*for(int i = 2;i<=n;i++){
			seq.add(seq.get(i-1)+seq.get(i-2));
		}*/
		
		return seq;
	}
	
	private static List<String> regularFizzBuzz(int n){
		List<String> toReturn = new ArrayList<>(n);
		
		for(int i=1;i<=n;i++){
			if(i%15==0){
				toReturn.add("FizzBuzz");
			}else if(i%5==0){
				toReturn.add("Buzz");
			}else if(i%3 ==0){
				toReturn.add("Fizz");
			}else{
				toReturn.add(Integer.toString(i));
			}
		}
		return toReturn;
	}
	

	private static List<String> alternateFizzBuzz(int n){
		List<String> toReturn = new ArrayList<>(n);
		for(int i=1;i<=n;i++){
			final String word = toWord(3,i,"Fizz") +toWord(5,i,"Buzz");
			
			if(StringUtil.isEmpty(word)){
				toReturn.add(Integer.toString(i));
			}else{
				toReturn.add(word);
			}
		}
		return toReturn;
	}

	private static String toWord(final int divisor, final int value, String word) {
		return (value % divisor) == 0 ? word:""; 
	}
	
}
