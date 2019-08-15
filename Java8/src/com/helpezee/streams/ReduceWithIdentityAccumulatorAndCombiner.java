package com.helpezee.streams;

import java.util.stream.Stream;

public class ReduceWithIdentityAccumulatorAndCombiner {

	public static void main(String[] args) {
		
		Integer arrSum = Stream.of(10, 20, 22, 12, 14).parallel().reduce(1000, (x, y) -> x + y, (p, q) -> {
			System.out.println("combiner called");
			return p + q;
		});
		
		System.out.println(arrSum);

	}

}
