package com.helpezee.multiplebounds;

public class MultipleBound {

	public static void main(String a[]) {
		// Creating object of sub class A and passing it to Bound as a type parameter.
		Bound<A> bea = new Bound<A>(new A());
		bea.doRunTest();

	}

}
