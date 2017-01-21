package com.gk.study.interviewexposed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

interface CoveredDistanceFinder {
	  void addInterval(int start, int end);
	  int getTotalCoveredLenth();
	}


class Interval{
	int start,end;
	
	Interval(){
		start=0;
		end=0;
	}
	
	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

public class OnDeckTests {
	
	public OnDeckTests(){
		matchers.put('{', '}');
		matchers.put('(', ')');
		matchers.put('[', ']');
		
		
	}
	

	public List<Interval> merge(List<Interval> intervals) {
		 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());
		for(Interval i:intervals){
			System.out.println("["+i.start+","+i.end+"]");
		}
		
		System.out.println("----");
 
		ArrayList<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
 
		result.add(prev);
 
		return result;
	}
	
	private  Map<Character, Character> matchers = new HashMap<>();// null;//ImmutableMap.of('{', '}', '(', ')', '[', ']');
	
	 
	public boolean validate(String s) {
	    Stack<Character> stack = new Stack<>();
	    for (Character c : s.toCharArray()) {    
	    	System.out.println("key:"+c+",stack:"+stack);
	    	
	        if (matchers.containsKey(c)) {
	        	System.out.println("Pushing->"+matchers.get(c));
	            stack.push(matchers.get(c));
	        } else if (matchers.containsValue(c) && (!stack.isEmpty()?c != stack.pop():false)){
	            return false;
	        }
	    }
	    return stack.empty();
	}
	
	
	public static void main(String args[]){
		List<String> subStrList = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.nextLine();
         
       // int k = 2; int l=4;
        //String str = "ababab";//sc.nextLine();
        //System.out.println("n:"+n+",k:"+k+"l:"+l+",m:"+m+",str:"+str);
        for(int i=0;i<str.length()-1;++i){
        	for(int j=k;(j<=l && i+j<=str.length());++j){
        		System.out.println(i+","+j);
        		System.out.println(i+","+j+",substr->"+str.substring(i,j));
        		//subStrList.add(str.substring(i,j));
        	}
        	
        	/*if(i+k<str.length()){
        		subStrList.add(str.substring(i,i+k));
        	}*/
        }
        
        for(String word:subStrList){
        	System.out.println(word);
            Integer count = wordCount.get(word);
            if(count == null){
                wordCount.put(word,1);
            } else {
                wordCount.put(word,count++); 
            }
        }
       int maxValue = 0;
       for (Integer value : wordCount.values()) {
            if(value>maxValue){
                maxValue = value;
            }
        }
        
        System.out.println(maxValue);
	}

}


