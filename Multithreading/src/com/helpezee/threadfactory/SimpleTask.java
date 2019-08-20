package com.helpezee.threadfactory;

public class SimpleTask implements Runnable {

	private long sleepTime;
	private String comment;

	public SimpleTask(String comment , long sleepTime) {
		super();
		this.sleepTime = sleepTime;
		this.comment  = comment;
	}

	@Override
	public void run() {
		//while (true) {
			try {
				System.out.println("Simple task is running on " + Thread.currentThread().getName() + " with priority "
						+ Thread.currentThread().getPriority() +" with comment  "+ comment);
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}

}