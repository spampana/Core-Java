package com.helpezee.innerclasses;

public class AirJet {
public static void main(String[] args) {
// instantiation 1
Engine engine1 = new AirJet().new Engine();
// instantiation 2
AirJet.Engine engine2 = new AirJet().new Engine();
// instantiation 3
AirJet airjet = new AirJet();
Engine engine3 = airjet.new Engine();
// instantiation 4
//Engine engine4 = new Engine();
}
class Engine{
}
}