package com.helpezee.threadfactory;

public class ThreadFactoryDemo {

	public static void main(String[] args) {
		DaemonThreadFactory daemontf = new DaemonThreadFactory();
		MaxPriorityThreadFactory mptf = new MaxPriorityThreadFactory();
		
		Runnable r = new SimpleTask("High Priority" ,1000);
		mptf.newThread(r).start();
		r = new SimpleTask("Low Priority" , 1000);
		daemontf.newThread(r).start();

	}

}

/*class SimpleTask implements Runnable{
	String s = null;
	public SimpleTask(String s){
		this.s = s;
	}
	@Override
	public void run() {
	  System.out.println(s+" Simple task done.");	
	}
} 
*/