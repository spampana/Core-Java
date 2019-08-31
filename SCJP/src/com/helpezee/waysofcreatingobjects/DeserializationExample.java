package com.helpezee.waysofcreatingobjects;

//Java program to illustrate creation of Object using Deserialization. 
import java.io.*; 

public class DeserializationExample 
{ 
	public static void main(String[] args) 
	{ 
		try
		{ 
			SerializationExample d; 
			FileInputStream f = new FileInputStream("file.txt"); 
			ObjectInputStream oos = new ObjectInputStream(f); 
			d = (SerializationExample)oos.readObject(); 
			System.out.println(d.name); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		
	} 
} 
