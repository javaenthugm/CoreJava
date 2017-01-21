package com.gk.study.newjava;

interface ArethemticOp{
	int sum(int x,int y);
}


public class LamdaTests {
	
	public static void main(String args[]){
		ArethemticOp sum = (x,y)->x+y;
		
		
		new Thread(()->{
			
			try {
			
				for(int i=0;i<50;i++){
					System.out.println(i+"-"+Thread.currentThread().getName());
					Thread.sleep(2000);					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
	}

}
