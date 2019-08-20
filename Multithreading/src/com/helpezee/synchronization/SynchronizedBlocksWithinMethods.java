package com.helpezee.synchronization;

public class SynchronizedBlocksWithinMethods {

	private int sum = 0;

	private static int staticSum = 0;

	public void calculate() {

		// we passed a parameter this to the synchronized block.
		// This is the monitor object, the code inside the block get
		// synchronized on the monitor object.
		// Simply put, only one thread per monitor object can execute inside
		// that block of code.
		synchronized (this) {
			setSum(getSum() + 1);
		}

	}

	//In case the method is static, we would pass class name in place of the object reference. 
	//And the class would be a monitor for synchronization of the block
	public static void calculate1() {

		synchronized (SynchronizedBlocksWithinMethods.class) {
			staticSum = staticSum + 1;
		}
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
