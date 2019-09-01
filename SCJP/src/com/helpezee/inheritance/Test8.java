package com.helpezee.inheritance;

class Derived4 
{ 
	protected final void getDetails() 
	{ 
		System.out.println("Derived class"); 
	} 
} 

public class Test8 extends Derived4 
{ 
	//Final and static methods cannot be overridden.
	protected final void getDetails() 
	{ 
		System.out.println("Test class"); 
	} 
	
	public static void main(String[] args) 
	{ 
		Derived4 obj = new Derived4(); 
		obj.getDetails(); 
	} 
} 
