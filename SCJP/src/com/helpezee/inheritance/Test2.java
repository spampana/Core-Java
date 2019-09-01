package com.helpezee.inheritance;

import java.io.IOException;

public class Test2 
{ 
	public int getData(String temp) throws IOException 
	{ 
		return 0; 
	}
	
	//Methods that throws different exceptions are not overloaded as their signature are still the same.
	public int getData(String temp) throws Exception 
	{ 
		return 1; 
	} 
	public static void main(String[] args) throws IOException 
	{ 
		Test2 obj = new Test2(); 
		System.out.println(obj.getData("GFG"));	 
	} 
} 
