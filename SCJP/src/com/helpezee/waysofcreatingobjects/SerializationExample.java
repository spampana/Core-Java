package com.helpezee.waysofcreatingobjects;

//Java program to illustrate Serializing an Object. 
import java.io.*; 

//Whenever we serialize and then deserialize an object, JVM creates a separate object. 
//In deserialization, JVM doesn’t use any constructor to create the object.
//To deserialize an object we need to implement the Serializable interface in the class.

class SerializationExample implements Serializable 
{ 

	private static final long serialVersionUID = 1L;
	String name;
	
	SerializationExample(String name) 
	{ 
		this.name = name; 
	} 

	public static void main(String[] args) 
	{ 
		try
		{ 
			SerializationExample d = new SerializationExample("GeeksForGeeks"); 
			FileOutputStream f = new FileOutputStream("file.txt"); 
			ObjectOutputStream oos = new ObjectOutputStream(f); 
			oos.writeObject(d); 
			oos.close(); 
			f.close(); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
