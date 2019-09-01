package com.helpezee.inheritance;

public class Test5 
{ 
	private String function(String temp, int data, int sum) 
	{ 
		return ("GFG"); 
	} 
	private String function(String temp, int data) 
	{ 
		return ("GeeksforGeeks"); 
	} 
	public static void main(String[] args) 
	{ 
		Test5 obj = new Test5(); 
		System.out.println(obj.function("GFG", 0, 20));	 
	} 
} 
