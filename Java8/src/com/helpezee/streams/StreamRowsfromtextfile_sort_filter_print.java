package com.helpezee.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRowsfromtextfile_sort_filter_print {

	public static void main(String[] args) throws IOException {
		
		Stream<String> bands = Files.lines(Paths.get("D:\\GIT\\Core-Java\\Java8\\src\\com\\helpezee\\streams\\bands.txt"));
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			.forEach(System.out::println);
		bands.close();

	}

}
