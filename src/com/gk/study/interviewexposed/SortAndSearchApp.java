package com.gk.study.interviewexposed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortAndSearchApp {

	public static void main(String args[]) {
		System.out.println("Input Array \t:"+Arrays.asList(6, 2, 4, -1, 4, 6, 3, 200));
		System.out.println("Bubble Sort \t:" + bubbleSort(Arrays.asList(6, 2, 4, -1, 4, 6, 3, 200)));
		System.out.println("Insertion Sort\t:"+insertionSort(Arrays.asList(6, 2, 4, -1, 4, 6, 3, 200)));
		System.out.println("Quick Sort \t:"+quickSort(Arrays.asList(6,2,4,-1,4,6,3,200)));
		System.out.println("Merger Sort \t:"+mergeSort(Arrays.asList(6, 2, 4, -1, 4, 6, 3, 200)));		
		System.out.println("Binary Serach 6 :"+binarySearch(mergeSort(Arrays.asList(6, 2, 4, -1, 4, 6, 3, 200)), 6));
		
	}

	public static boolean binarySearch(final List<Integer> numbers,
			final Integer value) {
		if (numbers == null || numbers.isEmpty())
			return false;

		final Integer comparison = numbers.get(numbers.size() / 2);

		if (value.equals(comparison))
			return true;

		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(
					numbers.subList(numbers.size() / 2 + 1, numbers.size()),
					value);
		}
	}

	public static List<Integer> mergeSort(List<Integer> numbers) {

		while (numbers.size() < 2) {
			return numbers;
		}

		final List<Integer> left = numbers.subList(0, numbers.size() / 2);
		//System.out.println("Left :" + left);
		final List<Integer> right = numbers.subList(numbers.size() / 2,
				numbers.size());
		//System.out.println("Right :" + right);
		return merge(mergeSort(left), mergeSort(right));
	}

	private static List<Integer> merge(final List<Integer> leftList,
			final List<Integer> rightList) {

		int leftPtr = 0, rightPtr = 0;

		final List<Integer> merged = new ArrayList<>(leftList.size()
				+ rightList.size());

		while (leftPtr < leftList.size() && rightPtr < rightList.size()) {
			if (leftList.get(rightPtr) < rightList.get(rightPtr)) {
				merged.add(leftList.get(leftPtr));
				leftPtr++;
			} else {
				merged.add(rightList.get(rightPtr));
				rightPtr++;
			}
		}

		while (leftPtr < leftList.size()) {
			merged.add(leftList.get(leftPtr));
			leftPtr++;
		}

		while (rightPtr < rightList.size()) {
			merged.add(rightList.get(rightPtr));
			rightPtr++;
		}

		return merged;

	}

	public static List<Integer> quickSort(List<Integer> numbers) {
		if (numbers.size() < 2)
			return numbers;

		int pivot = numbers.get(0);
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}

		List<Integer> sorted = quickSort(lower);
		sorted.add(pivot);
		sorted.addAll(quickSort(higher));

		return sorted;
	}
	
	public static List<Integer> insertionSort(final List<Integer> numbers){
		
		final List<Integer> sortedList = new LinkedList<>();
		
		originalList : for(Integer number : numbers){
			for(int i=0;i<sortedList.size();i++){
				if(number < sortedList.get(i)){
					sortedList.add(i,number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		
		return sortedList;
	}
	
	
	public static List<Integer> bubbleSort(List<Integer> numbers){
		
		boolean numberSwitched;
		do{
			numberSwitched = false;
			
			for(int i=0;i<numbers.size()-1;i++){
				if(numbers.get(i+1)<numbers.get(i)){
					int temp = numbers.get(i+1);
					numbers.set(i+1, numbers.get(i));
					numbers.set(i, temp);
					numberSwitched=true;
				}
			}
			
		}while(numberSwitched);
		
		return numbers;
		
	}
 
}
