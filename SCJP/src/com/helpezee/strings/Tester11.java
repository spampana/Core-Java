package com.helpezee.strings;

import java.util.Scanner;

public class Tester11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("javachamp 2009, true 239");
		while (sc.hasNext()) {
		//System.out.println(sc.next());
		if (sc.hasNextBoolean())
		System.out.print("Boolean");
		if (sc.hasNextInt())
		System.out.print("Int");
		sc.next();
		}
		}
}
