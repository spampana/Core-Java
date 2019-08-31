package com.helpezee.waysofcreatingobjects;

//If we know the name of the class & if it has a public default constructor we can create an object –Class.forName. We can use it to create the Object of a Class. 
//Class.forName actually loads the Class in Java but doesn’t create any Object. 
//To Create an Object of the Class you have to use the new Instance Method of the Class.
public class NewInstanceExample 
{ 
	String name = "GeeksForGeeks"; 
	public static void main(String[] args) 
	{ 
		try
		{ 
			Class cls = Class.forName("com.helpezee.waysofcreatingobjects.NewInstanceExample"); 
			NewInstanceExample obj = (NewInstanceExample) cls.newInstance(); 
			System.out.println(obj.name); 
		} 
		catch (ClassNotFoundException e) 
		{ 
			e.printStackTrace(); 
		} 
		catch (InstantiationException e) 
		{ 
			e.printStackTrace(); 
		} 
		catch (IllegalAccessException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
