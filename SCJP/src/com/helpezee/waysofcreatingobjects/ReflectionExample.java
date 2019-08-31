package com.helpezee.waysofcreatingobjects;

//Java program to illustrate creation of Object using newInstance() method of Constructor class 
import java.lang.reflect.*; 

//There is one newInstance() method in the java.lang.reflect.Constructor class which we can use to create objects. 
//It can also call parameterized constructor, and private constructor by using this newInstance() method.
public class ReflectionExample 
{ 
	private String name; 
	ReflectionExample() 
	{ 
	} 
	
	public void setName(String name) 
	{ 
		this.name = name; 
	} 
	
	public static void main(String[] args) 
	{ 
		try
		{ 
			Constructor<ReflectionExample> constructor = ReflectionExample.class.getDeclaredConstructor(); 
			ReflectionExample r = constructor.newInstance(); 
			r.setName("GeeksForGeeks"); 
			System.out.println(r.name); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
