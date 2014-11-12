package com.helpezee.strings;

public class Tester9 {
	public static void main(String[] args) {
		String s = "";
		Integer x = 5;
		StringBuffer sb = new StringBuffer();
		if (x < 15)
		s.concat("javachamp");
		else
		sb.append("javachamp"); 
		
		System.out.print(s); 
		System.out.println(sb);
		}
}
