package com.helpezee.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
	public static void main(String[] args) {
		String jc = "javachamp_champ2012champ";
		Pattern p = Pattern.compile(".{4}c+(m)*"); //line 1
		Matcher m = p.matcher(jc);
		while(m.find()) {
		System.out.print(m.start());
		}
		}
}
