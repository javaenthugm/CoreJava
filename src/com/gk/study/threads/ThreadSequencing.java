package com.gk.study.threads;

public class ThreadSequencing {
	
	public static void main(String args[]){
		
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am :"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"Thread-1");
		
		final Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t1.start();
				try{
					t1.join();
				}catch(InterruptedException i){
					i.printStackTrace();
				}
				
				System.out.println("I am:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
			}
		},"Thread-2");
		
		final Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				t2.start();
				
				try{
					t2.join();
				}catch(InterruptedException i){
					i.printStackTrace();
				}
				System.out.println("I am:"+Thread.currentThread().getName()+",id:"+Thread.currentThread().getId());
				
			}
		},"Thread-3");
		
		t3.start();
	}

}
