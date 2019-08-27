package com.helpezee.variables;

//A sample Java program to demonstrate use and working of blank final 



//Values must be assigned in constructor.

//If we have more than one constructors or overloaded constructor in class, then blank final variable must be initialized in all of them. 
//However constructor chaining can be used to initialize the blank final variable.

//Blank final variables are used to create immutable objects (objects whose members can’t be changed once initialized).
class Test 
{ 
	// We can initialize here, but if we initialize here, then all objects get the same value. So we use blank final 
	final int i; 

	Test(int x) 
	{ 
		// Since we have initialized above, we must initialize i in constructor. 
		// If we remove this line, we get compiler error. 
		i = x; 
	} 
	
	
	Test() 
    { 
		//constructor chaining to initialize final members , Calling Test(int val) 
        this(10); 
    } 
} 


public class FinalVariables 
{ 
	public static void main(String args[]) 
	{ 
		Test t1 = new Test(); 
		System.out.println(t1.i); 

		Test t2 = new Test(20); 
		System.out.println(t2.i); 
	} 
} 
