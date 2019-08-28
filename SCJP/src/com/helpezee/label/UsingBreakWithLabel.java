package com.helpezee.label;

//Java code to illustrate using label and break instead of goto 

public class UsingBreakWithLabel {
	public static void main(String[] args) {

		// label for outer loop
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 1)
					break outer;
				System.out.println(" value of j = " + j);
			}
		} // end of outer loop
	} // end of main()
} // end of class Main
