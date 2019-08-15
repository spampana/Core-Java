package com.helpezee.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRowsfromCSVfileandcount {

	public static void main(String[] args) throws IOException {
		Stream<String> rows1 = Files.lines(Paths.get("D:\\GIT\\Core-Java\\Java8\\src\\com\\helpezee\\streams\\data.txt"));
		int rowCount = (int)rows1
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.count();
		System.out.println(rowCount + " rows.");
		rows1.close();

	}

}
