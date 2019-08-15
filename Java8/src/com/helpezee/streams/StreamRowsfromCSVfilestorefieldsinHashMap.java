package com.helpezee.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRowsfromCSVfilestorefieldsinHashMap {

	public static void main(String[] args) throws IOException {
		
		Stream<String> rows3 = Files.lines(Paths.get("D:\\GIT\\Core-Java\\Java8\\src\\com\\helpezee\\streams\\data.txt"));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map = rows3
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.collect(Collectors.toMap( x -> x[0], x -> Integer.parseInt(x[1])));
		rows3.close();
		
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}

	}

}
