package com.helpezee.inheritance;


//Since the print method of superclass is static, compiler knows that it will not be 
//overridden in subclasses and hence compiler knows during compile time which print method 
//to call and hence no ambiguity.
public class StaticBinding 
{ 
	public static class superclass 
	{ 
		static void print() 
		{ 
			System.out.println("print in superclass."); 
		} 
	} 
	public static class subclass extends superclass 
	{ 
		static void print() 
		{ 
			System.out.println("print in subclass."); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		superclass A = new superclass(); 
		superclass B = new subclass(); 
		A.print(); 
		B.print(); 
	} 
} 
