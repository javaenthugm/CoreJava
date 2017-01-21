package com.gk.study.interviewexposed;

import org.junit.Assert;



enum SingletonEnum{
	INSTANCE;
	public void performSingletonOp(){
		System.out.println("Singleton operation");
	}
}

public class SingletonUsingEnumApp {

	public static void main(String args[]){
		SingletonEnum s1 = SingletonEnum.INSTANCE;
		SingletonEnum s2 = SingletonEnum.INSTANCE;
		
		Assert.assertSame(s1, s2);
		s1.performSingletonOp();
		s2.performSingletonOp();
	}
	
}
