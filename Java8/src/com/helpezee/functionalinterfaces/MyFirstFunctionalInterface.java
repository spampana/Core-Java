package com.helpezee.functionalinterfaces;

@FunctionalInterface
public interface MyFirstFunctionalInterface
{
    public void firstWork();
 
    default void doSomeMoreWork1(){
    //Method body
    }
 
    default void doSomeMoreWork2(){
    //Method body
    }
}