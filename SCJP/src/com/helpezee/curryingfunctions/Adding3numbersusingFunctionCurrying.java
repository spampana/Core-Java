package com.helpezee.curryingfunctions;

import java.util.function.Function;

public class Adding3numbersusingFunctionCurrying {

	public static void main(String[] args) {

		// Using Java 8 Functions to create lambda expressions for functions and with this, applying Function Currying 
  
        // Curried Function for Adding u, v & w 
        Function<Integer, Function<Integer, Function<Integer, Integer> > > triadder = u -> w -> v -> u + w + v; 
  
        // Calling Curried Function for Adding u, v & w 
        System.out.println("Add 2, 3, 4 :"  + triadder.apply(2).apply(3).apply(4)); 

	}

}
