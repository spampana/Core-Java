package com.helpezee.curryingfunctions;

import java.util.function.Function;

public class Multiplying2numbersusingFunctionCurrying {

	public static void main(String[] args) {

		// Using Java 8 Functions to create lambda expressions for functions and with this, applying Function Currying 
  
        // Curried Function for Multiplying u & v 
        Function<Integer, Function<Integer, Integer> > curryMulti = u -> v -> u * v; 
  
        // Calling Curried Function for Multiplying u & v 
        System.out.println("Multiply 2, 3 :" + curryMulti.apply(2).apply(3)); 

	}

}
