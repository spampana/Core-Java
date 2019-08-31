package com.helpezee.waysofcreatingobjects;

//Whenever clone() is called on any object, the JVM actually creates a new object and copies all content of the previous object into it.
//Creating an object using the clone method does not invoke any constructor.
//To use clone() method on an object we need to implement Cloneable and define the clone() method in it.
public class CloneExample implements Cloneable 
{ 
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	} 
	String name = "GeeksForGeeks"; 

	public static void main(String[] args) 
	{ 
		CloneExample obj1 = new CloneExample(); 
		System.out.println("obj1 hashcode---"+obj1.hashCode());
		try
		{ 
			CloneExample obj2 = (CloneExample) obj1.clone(); 
			System.out.println(obj2.name); 
			System.out.println("obj2 hashcode---"+obj2.hashCode());
		} 
		catch (CloneNotSupportedException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
