package com.helpezee.strings;

public class Tester12 {
	public static void main(String[] args) {
		String str = "java";
		StringBuffer sb = new StringBuffer("javachamp");
		sb.insert(9, ".com"); //sb=javachamp.com
		str.concat("champ");   //str=java
		if (sb.length() < 6 || str.equals("javachamp")) {
		System.out.print(sb);
		}
		sb.delete(2, 7); // sb=jamp.com element at 7 will not be deleted
		System.out.print(sb);
		}
}
