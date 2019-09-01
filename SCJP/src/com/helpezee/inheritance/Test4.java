package com.helpezee.inheritance;

//The order of argument are an important parameter for determining method overloading. 
//As the order of attributes are different, the methods are overloaded.
public class Test4 
{ 
	private String function(String temp, int data) 
	{ 
		return ("GFG"); 
	} 
	private String function(int data, String temp) 
	{ 
		return ("GeeksforGeeks"); 
	} 
	public static void main(String[] args) 
	{ 
		Test4 obj = new Test4(); 
		System.out.println(obj.function(4, "GFG"));	 
	} 
} 
