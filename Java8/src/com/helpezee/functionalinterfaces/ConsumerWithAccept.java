package com.helpezee.functionalinterfaces;

//Java Program to demonstrate 
//Consumer's accept() method 

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer; 

public class ConsumerWithAccept { 
	public static void main(String args[]) 
	{ 
		
		// Consumer to display a number 
		Consumer<Integer> display = a -> System.out.println(a); 

		// Implement display using accept() 
		display.accept(10); 
		
		System.out.println("############################");

		
		
		// Consumer to display a list of numbers 
		Consumer<List<Integer>>  dispList = list -> list.stream().forEach(a -> System.out.println(a + " ")); 

		List<Integer> list = new ArrayList<Integer>(); 
		list.add(2); 
		list.add(1); 
		list.add(3); 

		// Implement dispList using accept() 
		dispList.accept(list); 
	} 
} 
