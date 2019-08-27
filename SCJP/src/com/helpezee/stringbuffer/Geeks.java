package com.helpezee.stringbuffer;

//Java praogram to illustrate the java.lang.StringBuffer.appendCodePoint(int cp) 

public class Geeks {

	public static void main(String[] args) {

		StringBuffer sbf = new StringBuffer("Geeksforgeeks");
		System.out.println("String buffer = " + sbf);

		// Here it appends the CodePoint as string to the string buffer
		sbf.appendCodePoint(43);

		System.out.println("After appending CodePoint is = " + sbf);
	}
}
