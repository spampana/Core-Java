package com.helpezee.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iterate {

	public static void main(String[] args) {

		Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

		List<Integer> collect = evenNumStream.limit(5).collect(Collectors.toList());
		System.out.println(collect);//[2, 4, 8, 16, 32]
		
		/*
		 * Here, we pass 2 as the seed value, which becomes the first element of our stream. 
		 * This value is passed as input to the lambda, which returns 4. 
		 * This value, in turn, is passed as input in the next iteration.
		 * This continues until we generate the number of elements specified by limit() which acts as the terminating condition.
		 */

	}

}
