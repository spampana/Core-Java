package com.helpezee.inheritance;

//Access modifiers associated with methods doesn’t determine the criteria for overloading. 
//The overloaded methods could also be declared as final or static without affecting the overloading criteria.
public class Test3 
{ 
	private String function() 
	{ 
		return ("GFG"); 
	} 
	public final static String function(int data) 
	{ 
		return ("GeeksforGeeks"); 
	} 
	public static void main(String[] args) 
	{ 
		Test3 obj = new Test3(); 
		System.out.println(obj.function());	 
	} 
} 
