package com.helpezee.aboutnull;

public class InstanceOf {
	public static void main (String[] args) throws java.lang.Exception 
	{ 
		Integer i = null; 
		Integer j = 10; 
			
		//prints false 
		System.out.println(i instanceof Integer); 
		
		//Compiles successfully print true
		System.out.println(j instanceof Integer); 
	} 
}
