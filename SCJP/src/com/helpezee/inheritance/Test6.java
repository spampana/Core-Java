package com.helpezee.inheritance;

public class Test6 
{ 
	private String function(float i, int f) 
	{ 
		return ("gfg"); 
	} 
	private String function(double i, double f) 
	{ 
		return ("GFG"); 
	} 
	public static void main(String[] args) 
	{ 
		Test6 obj = new Test6(); 
		System.out.println(obj.function(1., 20));	 
	} 
} 
