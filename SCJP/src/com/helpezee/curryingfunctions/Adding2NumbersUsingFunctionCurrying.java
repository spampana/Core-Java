package com.helpezee.curryingfunctions;

import java.util.function.Function;

//Function Currying is a concept of breaking a function with many arguments into many functions with single argument in such a way,that the 
//output is same. In other words, its a technique of simplifying a multi-valued argument function into single-valued argument multi-functions.
public class Adding2NumbersUsingFunctionCurrying {

	public static void main(String[] args) {

		 // Using Java 8 Functions to create lambda expressions for functions and with this, applying Function Currying 
  
        // Curried Function for Adding u & v 
        Function<Integer, Function<Integer, Integer> > curryAdder = u -> v -> u + v; 
  
         // Calling Curried Function for Adding u & v 
        System.out.println("Add 2, 3 :"  + curryAdder.apply(2).apply(3)); 
  
        } 

	}


