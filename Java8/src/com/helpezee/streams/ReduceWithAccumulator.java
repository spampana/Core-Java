package com.helpezee.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceWithAccumulator {

	public static void main(String[] args) {

		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		
		//Variant 1
		
		Optional<Integer> intOptional = numbers.reduce((i, j) -> {
			return i * j;
		});
		/*
		1*2= 2
		2*3= 6
		6*4= 24
		24*5= 120
		*/
		
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120

	}

}

