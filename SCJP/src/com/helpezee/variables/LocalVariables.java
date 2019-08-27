package com.helpezee.variables;

// A variable defined within a block or method or constructor is called local variable.
//Initialization of Local Variable is Mandatory.
//static local variables are not allowed in Java
public class LocalVariables { 
	
	public void StudentAge() 
	{ 
		//The scope of these variables exists only within the block in which the variable is declared. 
		int age = 0; 
		age = age + 5; 
		System.out.println("Student age is : " + age); 
	} 

	public static void main(String args[]) 
	{ 
		LocalVariables obj = new LocalVariables(); 
		obj.StudentAge(); 
	} 
	
} 
