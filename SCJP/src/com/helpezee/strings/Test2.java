package com.helpezee.strings;

import java.util.Collection;
import java.util.List;

public class Test2 {
public static void hello(Collection x) {
System.out.println("Collection");
}
public static void main(String[] args) {
	
Test2 t = new Testing();
List x = null;
t.hello(x);
}
}
class Testing extends Test2 {
public static void hello(List x) {
System.out.println("List");
}
}