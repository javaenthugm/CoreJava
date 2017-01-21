package com.gk.study.concurrencyinpractice;

public class NotVisibility {
	
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready){
				System.out.println("yeilding...");
				Thread.yield();
			}
			System.out.println(number);
		}
	}
	
	public static void main(String args[]){
		System.out.println(ready);
		
		new ReaderThread().start();
		
		number = 42;
		ready = true;
	}

}
