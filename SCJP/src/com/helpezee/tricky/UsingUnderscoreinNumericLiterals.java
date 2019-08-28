package com.helpezee.tricky;

//A new feature was introduced by JDK 7 which allows to write numeric literals using the underscore character. 
//Numeric literals are broken to enhance the readability.
public class UsingUnderscoreinNumericLiterals {

	public static void main(String[] args) {

		int inum = 1_00_00_000; 
        System.out.println("inum:" + inum); 
 
        long lnum = 1_00_00_000; 
        System.out.println("lnum:" + lnum); 
 
        float fnum = 2.10_001F; 
        System.out.println("fnum:" + fnum); 
 
        double dnum = 2.10_12_001; 
        System.out.println("dnum:" + dnum); 
	}

}
