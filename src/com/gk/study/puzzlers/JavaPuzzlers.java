package com.gk.study.puzzlers;

import java.util.Arrays;
import java.util.Comparator;

public class JavaPuzzlers {

	public static void main(String args[]) {
		
		//System.out.println(p1_IsOdd(-9));
		
		//p2_TimeForAChange();
		//comparatorPuzzle();
		
		youAreSuchACharacter();
		
	}
	
	
	
	private static boolean p1_IsOdd(int i) {
		return i%2==1;
	}

	private static void p2_TimeForAChange() {
		System.out.println(2.00 - 1.10);
	}
	
	private static void youAreSuchACharacter(){
		System.out.print("H"+"a");
		System.out.print('H'+'a');
		System.out.print('a');
	}

	private static void comparatorPuzzle() {
		Integer big = new Integer(2000000000);
		Integer small = new Integer(-2000000000);
		Integer zero = new Integer(0);
		Integer[] arr = new Integer[] { big, small, zero };
		Arrays.sort(arr, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Integer) o2).intValue() - ((Integer) o1).intValue();
			}
		});
		System.out.println(Arrays.asList(arr));
	}

}
