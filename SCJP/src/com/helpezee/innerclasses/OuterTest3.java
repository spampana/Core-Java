package com.helpezee.innerclasses;

public class OuterTest3 {
public static void main(String args[]) {
// instantiation 1
Airplane3 airplane = new Airplane3();
Airplane3.BlackBox3 box1 = airplane.new BlackBox3();
// instantiation 2
Airplane3.BlackBox3 box2 = new Airplane3().new BlackBox3();
// instantiation 3
Airplane3 airplane3 = new Airplane3();
//BlackBox3 box3 = airplane3.new BlackBox3();
}
}
class Airplane3 {
class BlackBox3 {
}
}