package com.gk.study.interviewexposed;

public class TryCatchFinallySystemExistTest {
	
	public static void main(String args[]){
		System.out.println(tryCatchTest());
	}
	
	/**
	 * Will 'finally' block be printed if the'try' block has a return statement? (YES)
	 * Will 'finally' block be printed if there is 'System.exit()' in the try block (NO)
	 * 
	 * 
	 * */
	private static int tryCatchTest(){
		
		try{
			System.exit(0);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("printing finally");
		}
		
		return 2;
		
	}
}
