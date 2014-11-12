package com.helpezee.strings;

public class Tester4 {
	public static void main(String[] args) {
		StringBuffer buffer1 = new StringBuffer("javachamp");
		StringBuffer buffer2 = new StringBuffer(buffer1);
		if (buffer1.equals(buffer2))
		System.out.println("true");
		else
		System.out.println("false");
		}
}
