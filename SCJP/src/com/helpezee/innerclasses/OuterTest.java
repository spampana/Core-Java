package com.helpezee.innerclasses;

public class OuterTest {
public static void main(String args[]) {
Airplane airplane = new Airplane(); //line 5
Airplane.BlackBox box = airplane.new BlackBox(); // line 6
box.printVariables();
}
}
class Airplane {
String code = "11";
class BlackBox {
String code = "22";
public void printVariables() {
System.out.print(code); // line 19
System.out.print(Airplane.this.code); // line 20
}
}
}