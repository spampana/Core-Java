package com.helpezee.strings;

public class Tester6 {
	public static void main(String[] args) {
		String a = "javachamp";
		String b = "javachamp";
		String c = new String("javachamp");
		System.out.print(a==b); //true
		System.out.print(a==c); //false
		System.out.print(b.equals(c)); //true
		System.out.print(b.equals(a)); //true
		}
}
