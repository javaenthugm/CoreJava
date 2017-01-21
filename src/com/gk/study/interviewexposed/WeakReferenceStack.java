package com.gk.study.interviewexposed;

import java.util.ArrayList;
import java.util.List;

public class WeakReferenceStack<E> {

	private final List<WeakReferenceStack<E>> stackReferences;
	private int stackPointer=0;
	
	public WeakReferenceStack(){
		stackReferences = new ArrayList<>();
	}
	
	public void push(E element){
		//this.stackReferences.add(stackPointer, new WeakReference(element));
		
	}
	
}
