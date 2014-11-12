package com.helpezee.innerclasses;

public class AirPlane4 {
public void fly(int speed) {
final int e = 1;
class FlyingEquation {
{
System.out.println(e);// line 1
//System.out.println(speed);// line 2 
//-->Cannot refer to a non-final variable speed inside an inner class defined in a different method
}
}
}
}