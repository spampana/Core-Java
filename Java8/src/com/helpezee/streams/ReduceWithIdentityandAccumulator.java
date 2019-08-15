package com.helpezee.streams;

import java.util.stream.Stream;

public class ReduceWithIdentityandAccumulator {

	public static void main(String[] args) {
		
		Integer arrSum = Stream.of(10,20,22,12,14).reduce(1000, Integer::sum);
		System.out.println(arrSum); //1078
		
		/*
		1000+10 = 1010
		1010+20 = 1030
		1030+22 = 1052
		1052+12 = 1064
		1064+14 = 1078
		 */

		arrSum = Stream.of(10, 20, 22, 12, 14).reduce(1000, (x, y) -> x + y);
		System.out.println(arrSum); //1078
 
		String result = Stream.of("java", "c", "c#", "python").reduce("Languages:", (x, y) -> x + " | " + y);
		System.out.println(result); //Languages: | java | c | c# | python

 
	}

}
