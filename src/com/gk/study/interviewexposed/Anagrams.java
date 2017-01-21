package com.gk.study.interviewexposed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	
	private final Map<String, List<String>> lookup = new HashMap<String, List<String>>();

	
	public Anagrams(final List<String> words){
		
		for(final String word:words){
			final String signature = alphabetize(word);
			
			if(lookup.containsKey(signature)){
				lookup.get(signature).add(word);
			}else{
				final List<String> anagramList = new ArrayList<>();
				anagramList.add(word);
				lookup.put(signature, anagramList);
			}
		}
	}


	private String alphabetize(String word) {
		final byte[] bytes = word.getBytes();
		System.out.println(Arrays.toString(bytes));
		//bytes[bytes.length+1]=0;
		//System.out.println(bytes);
		Arrays.sort(bytes);
		System.out.println(Arrays.toString(bytes));
		
		return new String(bytes);
	}
	
	public List<String> getAnagrams(final String word){
		final String signature = alphabetize(word);
		final List<String> anagrams = lookup.get(signature);
		return anagrams==null?new ArrayList():anagrams;
	}
	
	public static void main(String args[]){
		List<String> words = Arrays.asList("test","testing","stet","hello","olleh");
		
		Anagrams ag = new Anagrams(words);
		
		List<String> aglist = ag.getAnagrams("estt");
		System.out.println(Arrays.toString(aglist.toArray()));
	} 
}
