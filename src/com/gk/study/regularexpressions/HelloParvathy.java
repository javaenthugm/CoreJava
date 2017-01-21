package com.gk.study.regularexpressions;

import java.util.Scanner;

public class HelloParvathy {
	
	public static void main(String ags[]){
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is your name?");
		if(userInput.hasNextLine()){
			System.out.println("My name is "+userInput.nextLine());
			
		}
		
		System.out.println("How are you doing?");
		if(userInput.hasNextLine()){
			System.out.println("I am doing "+userInput.nextLine());
			
		}

	}

}
