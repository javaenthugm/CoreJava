package com.gk.study.interviewexposed;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Assert;


class Pair implements Serializable{

	private static final long serialVersionUID = 1L;
	private final int number;
	private final String name;
	
	private final transient String deSer;
	
	Pair(int n,String nm){
		this.number = n;
		this.name = nm;
		deSer ="desc";
	}
	
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	
	public String getDeSer(){
		return deSer;
	}
	
	
}

public class SerializationTests {
	
	public static void main(String args[]){
		
		try {
			FileOutputStream fos = new FileOutputStream("serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeInt(100);
			
			Pair p = new Pair(50, "Test");
			
			oos.writeObject(p);
			
			oos.flush();
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			int i = ois.readInt();
			Assert.assertEquals(100, i);
			Pair ps = (Pair)ois.readObject();
			Assert.assertEquals(50, ps.getNumber());
			Assert.assertEquals("Test", ps.getName());			
			Assert.assertNull(ps.getDeSer());
			
			ois.close();
			fis.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
