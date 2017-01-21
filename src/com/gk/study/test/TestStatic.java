package com.gk.study.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TestStatic {
	
	
	
	static int countDuplicates(int[] numbers) {
		
		System.out.println(Arrays.toString(numbers));
		
		
		if(numbers.length<=0){
			return 0;
		}
		int counter = 0;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<numbers.length;i++){
			if(set.contains(numbers[i])){
				counter++;
			}else{
				set.add(numbers[i]);
			}
		}

		return counter; 
	}
	
	static String[] Braces(String[] values) {
		
		 Map<Character, Character> matchers = new HashMap<>();
		 matchers.put('{', '}');
		 matchers.put('(', ')');
		 matchers.put('[', ']');

		
		 String[] returnArray = new String[values.length];
		 
		 for(int i=0;i<values.length;i++){
			 Stack<Character> stack = new Stack<Character>();
			 for (Character c : values[i].toCharArray()) {    
			       if (matchers.containsKey(c)) {
			            stack.push(matchers.get(c));
			        } else if (matchers.containsValue(c) && ( (!stack.empty())? c != stack.pop():false )){
			           break;
			        }
			  }
			  if(stack.isEmpty()){
			   	returnArray[i] = "YES";
			  }else{
				returnArray[i] = "NO";
			  }
		 }
		 
		 
		return returnArray;

    }

	
	
	public static void main(String args[]){
		
		String[] arr = Braces(new String[]{"{} [] ()","{[}]"});
		for(String s:arr){
			System.out.println(s);
		}
		
		//System.out.println(countDuplicates(new int[]{1,3,1,4,5,6,3,2}));
	}
	
	class Volume {
		int main(int a) {
			return a * a * a;
		}

		int main(int a, int b, int c) {
			return a * b * c;
		}

		double main(double a) {
			return Math.PI * a * a * a * 2 / 3;
		}

		double main(double a, double b) {
			return b * Math.PI * a * a;
		}
	}

	class Display {
		void display(double x) {
			System.out.printf("%.3f\n", x);
		}
	}

	class Calculate {
		Scanner cin;
		Display output;

		Calculate() throws IOException {
			cin = new Scanner(System.in);
			output = new Display();
			if (cin == null)
				throw new IOException("dummy");
		}

		int getINTVal() {
			int x = cin.nextInt();
			if (x <= 0)
				throw new NumberFormatException(
						"All the values must be positive");
			return x;
		}

		double getDoubleVal() {
			double x = cin.nextDouble();
			if (x <= 0)
				throw new NumberFormatException(
						"All the values must be positive");
			return x;
		}

		Volume get_Vol() {
			return new Volume();
		}
	}

}



