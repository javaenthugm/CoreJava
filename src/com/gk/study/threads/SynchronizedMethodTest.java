package com.gk.study.threads;

/**
 * If you have two synchronized methods and two separate threads are calling these methods:
 * In this case, the thread-2 has to wait for thread-1 to finish. Because when t1 executes the m1, it held the monitor lock and will not release it unless it completely executes the m1
 * In order for t2 execute m2, it has to get the lock, but the lock is held by t1 and so t2 has to wait.
 * 
 * */

public class SynchronizedMethodTest {
	
	public synchronized void methodOne(){
		System.out.println("methodOne");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void methodTwo(){
		System.out.println("methodTwo");
	}

	public static void main(String args[]){
		final SynchronizedMethodTest test = new SynchronizedMethodTest();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.methodOne();
				test.methodTwo();
			}
		},"thread-1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.methodTwo();
				test.methodOne();
			}
		},"thread-2");
	
		t1.start();
		t2.start();	
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
