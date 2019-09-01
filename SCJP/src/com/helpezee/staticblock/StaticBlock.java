package com.helpezee.staticblock;

//filename: Main.java 
class Test { 
	{
		System.out.println("Initializer Block");
	}
	
	Test(){ 
        System.out.println("Constructor called"); 
    } 
	
	static int i; 
	int j; 
	
	// start of static block 
	static { 
		i = 10; 
		System.out.println("static block called "); 
	} 
	// end of static block 
} 

class StaticBlock { 
	public static void main(String args[]) { 
		
		Test t1 = new Test(); 
	    Test t2 = new Test(); 

		// Although we don't have an object of Test, static block is 
		// called because i is being accessed in following statement. 
		//System.out.println(Test.i); 
	} 
} 
