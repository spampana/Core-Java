package com.helpezee.search;

//Java program to demonstrate working of Collections. 
//binarySearch() 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 

public class CollectionsBinarySearch 
{ 
	public static void main(String[] args) 
	{ 
		List<Integer> al = new ArrayList<Integer>(); 
		al.add(1); 
		al.add(2); 
		al.add(3); 
		al.add(10); 
		al.add(20); 

		// 10 is present at index 3. 
		int key = 10; 
		//Collections.binarysearch() works for objects Collections like ArrayList and LinkedList.
		int res = Collections.binarySearch(al, key); 
		if (res >= 0) 
			System.out.println(key + " found at index = "+ res); 
		else
			System.out.println(key + " Not found"); 

		key = 15; 
		//Collections.binarysearch() works for objects Collections like ArrayList and LinkedList.
		res = Collections.binarySearch(al, key); 
		if (res >= 0) 
			System.out.println(key + " found at index = "+ res); 
		else
			System.out.println(key + " Not found"); 
	} 
} 

