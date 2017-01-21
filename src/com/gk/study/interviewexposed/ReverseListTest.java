package com.gk.study.interviewexposed;

import java.util.List;

import java.util.ArrayList;

public class ReverseListTest {
	
	public List<Integer> RecursiveReverse(final List<Integer> list){
		
		if(list.size()<=1){
			return list;
		}else{
			List<Integer> reverseList = new ArrayList<>();
			reverseList.add(list.get(list.size()-1));
			reverseList.addAll(list.subList(0, list.size()-1));
			return reverseList;
		}
	}

}
