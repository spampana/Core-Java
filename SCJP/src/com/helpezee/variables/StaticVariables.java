package com.helpezee.variables;

//Static variables are also known as Class variables.
//These variables are declared similarly as instance variables, 
//the difference is that static variables are declared using the static keyword within a class outside any method constructor or block.
//Initialization of Static Variable is not Mandatory.
class Emp { 

	// static variable salary 
	public static double salary; 
	public static String name = "Harsh"; 
} 

public class StaticVariables { 
	
	public static void main(String args[]) 
	{ 

		// accessing static variable without object 
		Emp.salary = 1000; 
		System.out.println(Emp.name + "'s average salary:"+ Emp.salary); 
	} 
} 
