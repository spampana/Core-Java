package com.helpezee.strings;

public class Tester1 {
public static void main(String[] args) {
StringBuffer sb1 = new StringBuffer("javachamp");
StringBuffer sb2 = new StringBuffer("javachamp");
boolean stmt1 =sb1.equals(sb2) ; //false
boolean stmt2 = sb1 == sb2; //false
String s1 = new String("javachamp");
String s2 = new String("javachamp");
boolean stmt3 = s1.equals(s2); //true
boolean stmt4 = s1 == s2; //false
System.out.println("stmt1--"+stmt1);
System.out.println("stmt2--"+stmt2);
System.out.println("stmt3--"+stmt3);
System.out.println("stmt4--"+stmt4);
}
}