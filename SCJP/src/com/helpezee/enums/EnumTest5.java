package com.helpezee.enums;


//Java program to demonstrate that enums can have constructor and concrete methods. 

//An enum (Note enum keyword inplace of class keyword) 
enum Color1
{ 
	RED, GREEN, BLUE; 

	// enum constructor called separately for each  constant 
	private Color1() 
	{ 
		System.out.println("Constructor called for : " + this.toString()); 
	} 

	// Only concrete (not abstract) methods allowed 
	public void Color1Info() 
	{ 
		System.out.println("Universal Color1"); 
	} 
} 

public class EnumTest5
{	 
	// Driver method 
	public static void main(String[] args) 
	{ 
		Color1 c1 = Color1.RED; 
		System.out.println(c1); 
		c1.Color1Info(); 
	} 
} 
