package com.helpezee.typeconversions;

public class Narrowing {
	public static void main(String[] argv) 
	  { 
	    char ch = 'c'; 
	    int num = 88; 
	    ch = (char) num; 
	    System.out.println("Char vaue  "+ch);
	    
	    
	    double d = 100.04;  
        
        //explicit type casting 
        long l = (long)d; 
          
        //explicit type casting  
        int i = (int)l;  
        System.out.println("Double value "+d); 
          
        //fractional part lost 
        System.out.println("Long value "+l);  
          
        //fractional part lost 
        System.out.println("Int value "+i);  
	  } 
}
