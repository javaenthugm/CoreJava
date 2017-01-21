package com.gk.study.interviewexposed;
/**
 * Java Puzzle to test understanding of Switch statement in Java
 * what is the value of x after this switch statements
 * 
 * The code is legal.
 * When a case is matched in switch, its code and all the subsequent case code will run unless break is encountered.
 * Switch statement can be added inside for each loop and the case statement can be present in any order.
 * 
 * */
public class SwitchTest {

	public static void main(String args[]) {
		int x = 0;

		int[] nums = { 1, 2, 3, 5 };

		for (int i : nums)
			switch (i) {
			case 1:
				x += i;
			case 5:
				x += i;
			default:
				x += i;
			case 2:
				x += i;
			}
		System.out.println(x);

	}

}
