package com.gk.study.hackerrank;

import java.util.Arrays;

public class TestClass {

	public static void main(String args[]) {
		//StairCase(6);
		System.out.println(sumOfIntegers(new int[]{1,2,3,4,5}));
		System.out.println(sumOfIntegers(new int[]{5,1,2,3,4,5}));
	}

	static void StairCase(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++){
				if ((i + j) > n) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}
	
	static long sumOfIntegers(int[] arr) {
		
		System.out.println(Arrays.toString(arr));
		
        long sum = 0;
        
        //for(int i=1;i<=arr[0];i++){
        for(int i=0;i<arr.length;i++){
        	sum+=arr[i];
        }
        
        return sum;
		
    }
}
