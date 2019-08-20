package com.helpezee.synchronization;

public class SynchronizedStaticMethods {

	static int staticSum = 0;

	public static synchronized void calculate() {
		staticSum = staticSum + 1;
	}

}
