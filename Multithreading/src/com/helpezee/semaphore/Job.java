package com.helpezee.semaphore;

public class Job implements Runnable {
	
	private Printer printer;
	private String jobName;  
	
	public Job(Printer printer, String jobName) {
		this.printer = printer;
		this.jobName = jobName;
	}
	@Override
	public void run() {
		System.out.println("Job sent to printer:"+ jobName);		
		printer.print(jobName);
	}
} 


