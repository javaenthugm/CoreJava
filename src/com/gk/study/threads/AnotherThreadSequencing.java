package com.gk.study.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnotherThreadSequencing {
	
	volatile int counter=0;
	
	public static void main(String args[]){
		
		List<String> l = new CopyOnWriteArrayList<>(); //new ArrayList<>();
		l.add("One");
		l.add("Two");
		l.add("Three");
		Iterator<String> i = l.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		
		
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am :"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"Thread-1");
		
		final Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("I am:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
			}
		},"Thread-2");
		
		final Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				System.out.println("I am:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
				
			}
		},"Thread-3");
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
