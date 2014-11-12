package com.helpezee.strings;

public class Tester7 {
	public static void main(String[] args) {
		String stmt = "JavaChamp is here to help you";
		for (String token : stmt.split("//s")) {
		System.out.print(token + " ");
		}
		}
}
