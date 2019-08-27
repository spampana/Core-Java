package com.helpezee.enums;


//Java program to demonstrate working of values(), ordinal() and valueOf() 
enum MyColor 
{ 
	RED, GREEN, BLUE; 
} 

public class EnumTest4 
{ 
	public static void main(String[] args) 
	{ 
		// Calling values() 
		MyColor arr[] = MyColor.values(); 

		// enum with loop 
		for (MyColor col : arr) 
		{ 
			// Calling ordinal() to find index  of MyColor. 
			System.out.println(col + " at index " + col.ordinal()); 
		} 

		// Using valueOf(). Returns an object of MyColor with given constant. 
		// Uncommenting second line causes exception IllegalArgumentException 
		System.out.println(MyColor.valueOf("RED")); 
		// System.out.println(Color.valueOf("WHITE")); 
	} 
} 
