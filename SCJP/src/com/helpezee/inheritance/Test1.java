package com.helpezee.inheritance;

public class Test1 
{ 
	public int getData() //getdata() 1 
	{ 
		return 0; 
	} 
	//For method overloading, methods must have different signatures. 
	//Return type of methods does not contribute towards different method signature, so the code above give compilation error. 
	//Both getdata 1 and getdata 2 only differ in return types and NOT signatures.
	
	public long getData() //getdata 2 
	{ 
		return 1; 
	} 
	public static void main(String[] args) 
	{ 
		Test1 obj = new Test1(); 
		System.out.println(obj.getData());	 
	} 
} 
