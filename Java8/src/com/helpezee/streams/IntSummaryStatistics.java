package com.helpezee.streams;

import java.util.stream.IntStream;

public class IntSummaryStatistics {

	public static void main(String[] args) {
		
		java.util.IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
			System.out.println(summary);

	}

}
