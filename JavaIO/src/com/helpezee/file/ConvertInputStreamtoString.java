package com.helpezee.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConvertInputStreamtoString {
	public static void main(String[] args) throws IOException {
		 
		// intilize an InputStream
		InputStream is = new ByteArrayInputStream("file content..blah blah".getBytes());
 
		String result = getStringFromInputStream(is);
 
		System.out.println(result);
		System.out.println("Done");
 
	}
 
	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {
 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return sb.toString();
 
	}
}
