package com.helpezee.inheritance;

class Derived5 
{ 
	public void getDetails(String temp) 
	{ 
		System.out.println("Derived class " + temp); 
	} 
} 

public class Test9 extends Derived5 
{ 
	//The overriding method must have same signature, which includes, the argument list and the return type.
	public int getDetails(String temp) 
	{ 
		System.out.println("Test class " + temp); 
		return 0; 
	} 
	public static void main(String[] args) 
	{ 
		Test9 obj = new Test9(); 
		obj.getDetails("GFG"); 
	} 
} 
