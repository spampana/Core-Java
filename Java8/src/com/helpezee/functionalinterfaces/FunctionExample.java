package com.helpezee.functionalinterfaces;

import java.util.function.Function; 

public class FunctionExample { 
	public static void main(String args[]) 
	{ 

		// Function which takes in a number  and returns half of it 
		Function<Integer, Double> half = a -> a / 2.0; 
		
	    // Now treble the output of half function 
        half = half.andThen(a -> 3 * a); 
  
        // apply the function to get the result 
        System.out.println(half.apply(10)); 
        
        System.out.println("###################################");
        
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);
        
        System.out.println("###################################");
        
        Function<Integer, Integer> times2 = e -> e * 2;

        Function<Integer, Integer> squared = e -> e * e;  
        
        times2.compose(squared).apply(4);  // Returns 32

        times2.andThen(squared).apply(4);    // Returns 64
     
	} 
} 

