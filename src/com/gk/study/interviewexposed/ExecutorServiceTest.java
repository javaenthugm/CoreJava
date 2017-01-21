package com.gk.study.interviewexposed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPrinter implements Runnable{
	
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("From Printer Thread->"+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}


public class ExecutorServiceTest {
	
	public static void main(String args[]){
		final ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new ThreadPrinter());
		exe.execute(new ThreadPrinter());
		exe.execute(new ThreadPrinter());
		
		exe.shutdown();
	}

}
