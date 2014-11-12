package com.helpezee.strings;

public class StringComparision1 {
	public static void main(String[] args) {
		boolean stmt1 = "champ" == "champ";
		//System.out.println(stmt1);
		boolean stmt2 = new String("champ").equals(new String("champ"));
		//System.out.println(stmt2);
		boolean stmt3 = "champ".toString()=="champ";
		//System.out.println(stmt3);
		System.out.println(stmt1 && stmt2 && stmt3);

	
	}
}
