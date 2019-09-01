package com.helpezee.inheritance;


class Derived3 
{ 
	public void getDetails() 
	{ 
		System.out.println("Derived class"); 
	} 
} 

public class Test10 extends Derived3 
{ 
	// The overriding method can not have more restrictive access modifier.
	protected void getDetails() 
	{ 
		System.out.println("Test class"); 
	} 
	public static void main(String[] args) 
	{ 
		Derived3 obj = new Test10(); // line xyz 
		obj.getDetails(); 
	} 
} 
