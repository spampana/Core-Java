package com.helpezee.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRowsfromCSVfileparsedatafromrows {

	public static void main(String[] args) throws IOException {
		
		Stream<String> rows2 = Files.lines(Paths.get("D:\\GIT\\Core-Java\\Java8\\src\\com\\helpezee\\streams\\data.txt"));
		
		rows2
		.map(x -> x.split(","))
		.filter(x -> x.length == 3)
		.filter(x -> Integer.parseInt(x[1]) > 15)
		.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();

	}

}
