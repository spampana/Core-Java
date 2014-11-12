package com.helpezee.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tester8 {
public static void main(String[] args) {
Pattern p = Pattern.compile("[a-f]\\d+");
Matcher m = p.matcher("ab34ef0");
while(m.find()) {
System.out.print(m.start()+" "+m.group());
}
}
}