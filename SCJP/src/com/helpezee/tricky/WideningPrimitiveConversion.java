package com.helpezee.tricky;


//When we use double quotes, the text is treated as a string and “YO” is printed, but when we use single quotes, 
//the characters ‘L’ and ‘O’ are converted to int. 
//This is called widening primitive conversion. 
//After conversion to integer, the numbers are added ( ‘L’ is 76 and ‘O’ is 79) and 155 is printed.
public class WideningPrimitiveConversion {
	public static void main(String[] args) {
		System.out.print("Y" + "O");
		System.out.print('L' + 'O');
	}
}
