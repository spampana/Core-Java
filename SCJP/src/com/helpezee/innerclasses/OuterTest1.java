package com.helpezee.innerclasses;

public class OuterTest1 {
public static void main(String args[]) {
Airplane1.BlackBox box = new Airplane1().new BlackBox(); // line 1
box.printVariables();
}
}
class Airplane1 {
String code = "11";
class BlackBox {
String code = "22";
public void printVariables() {
System.out.print(code);
System.out.print(Airplane1.this.code); // line 20
}
}
}