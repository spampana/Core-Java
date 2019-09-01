package com.helpezee.inheritance;


class Derived1 
{ 
	public void getDetails() 
	{ 
		System.out.printf("Derived class "); 
	} 
} 

public class Test12 extends Derived1 
{ 
	public void getDetails() 
	{ 
		System.out.printf("Test class "); 
		super.getDetails(); 
	} 
	
	public static void main(String[] args) 
	{ 
		Derived1 obj = new Test12(); 
		obj.getDetails(); 
	} 
} 
