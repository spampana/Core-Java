package com.helpezee.threadlocal;

class MyThreadLocalDemo extends Thread {

	ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
	
	//Initial ThreadLocal Value
	private ThreadLocal myThreadLocal = new ThreadLocal<String>() {
		//you can specify an initial value for a ThreadLocal object by subclassing ThreadLocal and overriding the initialValue() method.
	    @Override 
	    protected String initialValue() {
	        return "This is the initial value";
	    }
	};   
	
	int value;

	public MyThreadLocalDemo(String name) {
		super(name);
	}

	public void run() {
		threadLocalValue.set((int) (Math.random() * 1000));
		value = threadLocalValue.get();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Local Value for " + Thread.currentThread().getName() + " : " + threadLocalValue.get());
		System.out.println("Thread value for "+Thread.currentThread().getName()+" value "+value);
	}
}

public class ThreadLocalTestClass {
	public static void main(String args[]){
		
		MyThreadLocalDemo t1 = new MyThreadLocalDemo("First");
		MyThreadLocalDemo t2 = new MyThreadLocalDemo("Second");
		MyThreadLocalDemo t3 = new MyThreadLocalDemo("Third");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

//Refer : https://helpezee.wordpress.com/2019/04/15/threadlocal/