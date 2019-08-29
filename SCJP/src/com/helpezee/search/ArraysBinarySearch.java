package com.helpezee.search;


import java.util.Arrays; 

public class ArraysBinarySearch { 
	public static void main(String[] args) 
	{ 
		int arr[] = { 10, 20, 15, 22, 35 }; 
		
		Arrays.sort(arr); 

		int key = 22; 
		//Arrays.binarysearch() works for arrays which can be of primitive data type also.
		int res = Arrays.binarySearch(arr, key); 
		if (res >= 0) 
			System.out.println(key + " found at index = "+ res); 
		else
			System.out.println(key + " Not found"); 

		key = 40; 
		//Arrays.binarysearch() works for arrays which can be of primitive data type also.
		res = Arrays.binarySearch(arr, key); 
		if (res >= 0) 
			System.out.println(key + " found at index = "+ res); 
		else
			System.out.println(key + " Not found"); 
	} 
} 
