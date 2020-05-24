package javPrac;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SportPopularity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Limit");

		String[] splitStr = null;

		int limit = sc.nextInt();
		sc.skip(System.lineSeparator());//Skip the next line

		TreeMap<String, String> tm = new TreeMap<String, String>(); //Will Contain list without Repeated names
		TreeMap<String, Integer> tmCount = new TreeMap<String, Integer>(); //Used for counting the sport

		String[] arrList = new String[limit];//Input Array Initialization

		//Input form user
		for(int i = 0; i < limit; i++) {
			arrList[i] = sc.nextLine().toLowerCase();
		}

		/*
		 * Split the Array by space and put it map
		 * Reverse Array because we wanted to avoid duplication and needed first input 
		 * */
		for(int i = limit-1; i >= 0; i--) {
			splitStr = arrList[i].split(" ",2);
			tm.put(splitStr[0],splitStr[1]);
		}

		
		//Count the no. of sports 
		for(Map.Entry<String, String> me : tm.entrySet()) {;
			if(tmCount.get(me.getValue()) == null) {
				tmCount.put(me.getValue(), new Integer(1));
			}else {
				tmCount.put(me.getValue(), new Integer(tmCount.get(me.getValue())+1));
			}
		}
		
		//Count the highest no
		int highestValue = 0;
		for(Map.Entry<String, Integer> me : tmCount.entrySet()) {
			if ( me.getValue() >= highestValue ) {
				highestValue = me.getValue();
			}
		}
		
		//To print the Sprt with highest values
		for(Map.Entry<String, Integer> me : tmCount.entrySet()) {
			if(me.getValue().equals(highestValue)) {
				System.out.println(me.getKey());
			}
		}
		System.out.println(tmCount.get("football"));//Print no of people likes football
		

	}

}
