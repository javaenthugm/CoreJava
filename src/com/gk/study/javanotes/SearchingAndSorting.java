package com.gk.study.javanotes;

import java.util.Arrays;

class PhoneDirectory{
	
	static class PhoneEntry{
		String name;
		String number;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		
		
		
	}
	
	private PhoneEntry[] data;
	private int dataCount = 0;
	public PhoneDirectory(){
		data = new PhoneEntry[1];
		dataCount=0;
	}
	
	public int find(String name){
		for(int i=0;i<dataCount;i++){
			if(data[i].name.equals(name)){
				return i;
			}
		}
		
		return -1;
	}
	
	public String getNumber(String name){
		
		int position = find(name);
		if(position==-1){
			return null;
		}else{
			return data[position].number;
		}
		
	}
	
	public void putNumber(String name, String number){
		if(name == null || number == null){
			throw new IllegalArgumentException("Name and Number cannot be null");
		}
		int poisition = find(name);
		if(poisition>=0){
			data[poisition].number=number;			
		}else{
			if(dataCount==data.length){
				data = Arrays.copyOf(data, data.length*2);
			}
			PhoneEntry newEntry = new PhoneEntry();
			newEntry.name=name;
			newEntry.number=number;
			
			data[dataCount] = newEntry;
			dataCount++;
		}
		
	}
}

class Person implements Comparable{
	private String name;

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}


public class SearchingAndSorting {
	
	public static void main(String args[]){
		/*PhoneDirectory pd = new PhoneDirectory();
		pd.putNumber("Gopi", "650-787-7549");pd.putNumber("Paru", "650-777-7549");pd.putNumber("Sindhu", "650-707-7549");
		if(pd.find("Paru")!=-1){
			System.out.println("Paru's number exists and number is ->"+pd.getNumber("Paru"));
		}*/
		
		//insertionSort(new int[]{2,1,3,0,3,-1});
		
		selectionSort(new int[]{2,1,3,0,3,-1});
	}
	
   private static void selectionSort(int[] arrayToSort){
		
		for(int lastPlace= arrayToSort.length-1;lastPlace>0;lastPlace--){
			
			int maxLoc = 0;
			for(int i=1;i<=lastPlace;i++){
				if(arrayToSort[i]>arrayToSort[maxLoc]){
					maxLoc=i;
				}
			}
			
			int temp = arrayToSort[maxLoc];
			arrayToSort[maxLoc] = arrayToSort[lastPlace];
			arrayToSort[lastPlace] = temp;
			
		}
		
		System.out.println(Arrays.toString(arrayToSort));
	}
   
   
	private static void insertionSort(int[] arrayToBeSorted){
		
		int itemSorted;
		
		for(itemSorted=1;itemSorted<arrayToBeSorted.length;itemSorted++){
			//Assume that all items [0],[1],[2] ...[itemSorted-1] are of arrayTobeSorted are already sorted
			
			int temp = arrayToBeSorted[itemSorted];
			int loc = itemSorted-1;
			System.out.println("outside temp:"+temp+",loc:"+loc);
			while(loc>=0 && arrayToBeSorted[loc] > temp ){
				System.out.println("inside temp:"+temp+",loc:"+loc+",arrayToBeSorted[loc]:"+arrayToBeSorted[loc] );
				System.out.println("1:"+Arrays.toString(arrayToBeSorted));
				arrayToBeSorted[loc+1] = arrayToBeSorted[loc];
				System.out.println("2:"+Arrays.toString(arrayToBeSorted));
				loc = loc-1;
				System.out.println("loc now:"+loc);
			}
			
			arrayToBeSorted[loc+1] = temp;
			System.out.println("3:"+Arrays.toString(arrayToBeSorted));
		}
		
		//System.out.println(Arrays.toString(arrayToBeSorted));
		
	}
	
	

}
