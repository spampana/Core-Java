package com.helpezee.stringbuffer;

//Java praogram to illustrate the java.lang.StringBuffer.appendCodePoint(int cp) 

public class AppendCodePointExample {

	public static void main(String[] args) {

		StringBuffer sbf = new StringBuffer("Geeksforgeeks");
		System.out.println("String buffer = " + sbf);

		// Here it appends the CodePoint as String to the string buffer
		sbf.appendCodePoint(65);
		System.out.println("After appending CodePoint is = " + sbf);
	}
}
