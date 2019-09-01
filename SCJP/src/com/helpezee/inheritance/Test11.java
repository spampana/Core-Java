package com.helpezee.inheritance;


import java.io.IOException; 

class Derived2 
{ 
	public void getDetails() throws IOException //line 23 
	{ 
		System.out.println("Derived class"); 
	} 
} 

public class Test11 extends Derived2 
{ 
	//The exception thrown by the overriding method should not be new or more broader checked exception
	public void getDetails() throws Exception //line 24 
	{ 
		System.out.println("Test class"); 
	} 
	public static void main(String[] args) throws IOException //line 25 
	{ 
		Derived2 obj = new Test11(); 
		obj.getDetails(); 
	} 
} 
